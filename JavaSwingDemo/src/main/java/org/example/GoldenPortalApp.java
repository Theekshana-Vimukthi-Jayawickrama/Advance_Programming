package org.example;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Dark / gold "Discover → Design" landing UI with FlatLaf + Timer animation.
 * Layout: BorderLayout (text WEST, animated art CENTER).
 */
public class GoldenPortalApp {

    private static final Color GOLD = new Color(248, 224, 142);
    private static final Color GOLD_DIM = new Color(212, 175, 90);
    private static final Color TEXT = new Color(245, 245, 245);
    private static final Color MUTED = new Color(200, 200, 205);

    private enum Scene { DISCOVER, DESIGN }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        UIManager.put("Button.arc", 999);
        UIManager.put("Component.focusWidth", 0);

        SwingUtilities.invokeLater(GoldenPortalApp::createAndShow);
    }

    private static void createAndShow() {
        JFrame frame = new JFrame("Golden Portal — Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(980, 560));

        PortalScene scene = new PortalScene();
        frame.setContentPane(scene);
        frame.setSize(1180, 680);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        scene.startAnimation();
    }

    /** Root panel: BorderLayout + Card-style scene switching. */
    private static final class PortalScene extends JPanel {
        private final TextPanel textPanel = new TextPanel();
        private final ArtPanel artPanel = new ArtPanel();
        private Scene current = Scene.DISCOVER;
        private Timer timer;

        PortalScene() {
            super(new BorderLayout());
            setBackground(Color.BLACK);
            add(textPanel, BorderLayout.WEST);
            add(artPanel, BorderLayout.CENTER);
            applyScene(Scene.DISCOVER, false);

            textPanel.exploreButton.addActionListener(this::onExplore);
        }

        private void onExplore(ActionEvent e) {
            applyScene(current == Scene.DISCOVER ? Scene.DESIGN : Scene.DISCOVER, true);
        }

        private void applyScene(Scene scene, boolean animateText) {
            current = scene;
            textPanel.showScene(scene, animateText);
            artPanel.showScene(scene);
        }

        void startAnimation() {
            timer = new Timer(16, e -> {
                artPanel.tick();
                artPanel.repaint();
            });
            timer.start();
        }
    }

    /** Left copy block — uses BoxLayout (vertical). */
    private static final class TextPanel extends JPanel {
        private final JLabel eyebrow = new JLabel("HOW WE WORK");
        private final JLabel number = new JLabel("01");
        private final JLabel title = new JLabel("Discover");
        private final JTextArea body = new JTextArea();
        final JButton exploreButton = new JButton("  EXPLORE MORE  ");

        private float fade = 1f;
        private Timer fadeTimer;

        TextPanel() {
            setOpaque(false);
            setPreferredSize(new Dimension(420, 0));
            setBorder(BorderFactory.createEmptyBorder(56, 48, 40, 24));
            setLayout(new BorderLayout());

            JPanel top = new JPanel();
            top.setOpaque(false);
            top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

            styleEyebrow(eyebrow);
            styleNumber(number);
            styleTitle(title);
            styleBody(body);

            JPanel numLine = new JPanel();
            numLine.setOpaque(false);
            numLine.setLayout(new BoxLayout(numLine, BoxLayout.X_AXIS));
            numLine.setAlignmentX(Component.LEFT_ALIGNMENT);
            numLine.add(number);
            numLine.add(Box.createHorizontalStrut(14));
            numLine.add(new GoldBar(48, 2));

            eyebrow.setAlignmentX(Component.LEFT_ALIGNMENT);
            title.setAlignmentX(Component.LEFT_ALIGNMENT);
            body.setAlignmentX(Component.LEFT_ALIGNMENT);

            top.add(eyebrow);
            top.add(Box.createVerticalStrut(28));
            top.add(numLine);
            top.add(Box.createVerticalStrut(18));
            top.add(title);
            top.add(Box.createVerticalStrut(18));
            top.add(body);

            styleExplore(exploreButton);

            JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            bottom.setOpaque(false);
            bottom.add(new CircleArrow());
            bottom.add(Box.createHorizontalStrut(12));
            bottom.add(exploreButton);

            add(top, BorderLayout.CENTER);
            add(bottom, BorderLayout.SOUTH);
        }

        void showScene(Scene scene, boolean animate) {
            Runnable apply = () -> {
                if (scene == Scene.DISCOVER) {
                    eyebrow.setText("HOW WE WORK");
                    number.setText("01");
                    title.setText("Discover");
                    body.setText("We listen first: your goals, your users and your constraints. You get a clear scope and an honest plan.");
                } else {
                    eyebrow.setText("HOW WE WORK");
                    number.setText("02");
                    title.setText("Design");
                    body.setText("Flows, prototypes and architecture, reviewed with you before a line of production code is written.");
                }
                revalidate();
                repaint();
            };

            if (!animate) {
                apply.run();
                fade = 1f;
                return;
            }

            if (fadeTimer != null) fadeTimer.stop();
            fade = 1f;
            fadeTimer = new Timer(16, null);
            fadeTimer.addActionListener(ev -> {
                fade -= 0.08f;
                if (fade <= 0f) {
                    fade = 0f;
                    apply.run();
                    fadeTimer.stop();
                    Timer in = new Timer(16, null);
                    in.addActionListener(e2 -> {
                        fade += 0.08f;
                        if (fade >= 1f) {
                            fade = 1f;
                            in.stop();
                        }
                        applyFade();
                    });
                    in.start();
                }
                applyFade();
            });
            fadeTimer.start();
        }

        private void applyFade() {
            float a = Math.max(0f, Math.min(1f, fade));
            setForegroundAlpha(eyebrow, a);
            setForegroundAlpha(number, a);
            setForegroundAlpha(title, a);
            body.setForeground(withAlpha(MUTED, a));
            repaint();
        }

        private static void setForegroundAlpha(JLabel label, float a) {
            Color c = label == null ? TEXT : label.getForeground();
            if (label.getClientProperty("baseFg") == null) {
                label.putClientProperty("baseFg", label.getForeground());
            }
            Color base = (Color) label.getClientProperty("baseFg");
            label.setForeground(withAlpha(base, a));
        }

        private static Color withAlpha(Color c, float a) {
            return new Color(c.getRed(), c.getGreen(), c.getBlue(), Math.round(255 * a));
        }

        private static void styleEyebrow(JLabel l) {
            l.setFont(new Font("SansSerif", Font.BOLD, 12));
            l.setForeground(MUTED);
            l.putClientProperty("baseFg", MUTED);
        }

        private static void styleNumber(JLabel l) {
            l.setFont(new Font("SansSerif", Font.BOLD, 14));
            l.setForeground(GOLD);
            l.putClientProperty("baseFg", GOLD);
        }

        private static void styleTitle(JLabel l) {
            l.setFont(new Font("SansSerif", Font.BOLD, 64));
            l.setForeground(TEXT);
            l.putClientProperty("baseFg", TEXT);
        }

        private static void styleBody(JTextArea t) {
            t.setOpaque(false);
            t.setEditable(false);
            t.setFocusable(false);
            t.setLineWrap(true);
            t.setWrapStyleWord(true);
            t.setFont(new Font("SansSerif", Font.PLAIN, 15));
            t.setForeground(MUTED);
            t.setBorder(null);
            t.setMaximumSize(new Dimension(340, 120));
        }

        private static void styleExplore(JButton b) {
            b.setFont(new Font("SansSerif", Font.BOLD, 12));
            b.setForeground(TEXT);
            b.setBackground(new Color(0, 0, 0, 0));
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
            b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            b.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override public void mouseEntered(java.awt.event.MouseEvent e) { b.setForeground(GOLD); }
                @Override public void mouseExited(java.awt.event.MouseEvent e) { b.setForeground(TEXT); }
            });
        }
    }

    private static final class GoldBar extends JComponent {
        private final int w;
        private final int h;

        GoldBar(int w, int h) {
            this.w = w;
            this.h = h;
            setPreferredSize(new Dimension(w, h));
            setMaximumSize(new Dimension(w, h));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(new GradientPaint(0, 0, GOLD, w, 0, GOLD_DIM));
            g2.fillRoundRect(0, 0, w, h, 2, 2);
            g2.dispose();
        }
    }

    private static final class CircleArrow extends JComponent {
        CircleArrow() {
            setPreferredSize(new Dimension(36, 36));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(1.4f));
            g2.setColor(new Color(255, 255, 255, 180));
            g2.drawOval(2, 2, 30, 30);
            g2.drawLine(12, 18, 22, 18);
            g2.drawLine(18, 14, 22, 18);
            g2.drawLine(18, 22, 22, 18);
            g2.dispose();
        }
    }

    /** Right side: background image + rotating gold rings / A mark. */
    private static final class ArtPanel extends JPanel {
        private BufferedImage discoverImg;
        private BufferedImage designImg;
        private BufferedImage currentImg;
        private double angle;
        private float pulse;
        private Scene scene = Scene.DISCOVER;

        ArtPanel() {
            setOpaque(true);
            setBackground(Color.BLACK);
            discoverImg = load("images/discover.jpg");
            designImg = load("images/design.png");
            currentImg = discoverImg;
        }

        void showScene(Scene scene) {
            this.scene = scene;
            currentImg = scene == Scene.DISCOVER ? discoverImg : designImg;
            repaint();
        }

        void tick() {
            angle += 0.012;
            pulse += 0.045;
        }

        private static BufferedImage load(String path) {
            try {
                URL url = GoldenPortalApp.class.getClassLoader().getResource(path);
                if (url == null) return null;
                return ImageIO.read(url);
            } catch (IOException e) {
                return null;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            int w = getWidth();
            int h = getHeight();

            if (currentImg != null) {
                drawCover(g2, currentImg, w, h);
                // Darken left edge so text panel blends in
                g2.setPaint(new GradientPaint(0, 0, new Color(0, 0, 0, 210), Math.min(280, w / 3), 0, new Color(0, 0, 0, 0)));
                g2.fillRect(0, 0, Math.min(320, w / 2), h);
            } else {
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, w, h);
            }

            // Frosted glass strip behind title area (Design vibe)
            if (scene == Scene.DESIGN) {
                g2.setColor(new Color(90, 90, 95, 70));
                g2.fillRoundRect(w / 8, h / 2 - 48, w * 3 / 4, 96, 8, 8);
            }

            drawPortal(g2, w, h);
            g2.dispose();
        }

        private void drawCover(Graphics2D g2, BufferedImage img, int w, int h) {
            double scale = Math.max(w / (double) img.getWidth(), h / (double) img.getHeight());
            int dw = (int) Math.round(img.getWidth() * scale);
            int dh = (int) Math.round(img.getHeight() * scale);
            int x = (w - dw) / 2;
            int y = (h - dh) / 2;
            g2.drawImage(img, x, y, dw, dh, null);
        }

        private void drawPortal(Graphics2D g2, int w, int h) {
            int cx = (int) (w * 0.62);
            int cy = (int) (h * 0.48);
            float glow = 0.55f + 0.2f * (float) Math.sin(pulse);

            // Soft gold bloom
            RadialGradientPaint bloom = new RadialGradientPaint(
                    cx, cy, Math.min(w, h) * 0.35f,
                    new float[]{0f, 0.45f, 1f},
                    new Color[]{
                            new Color(255, 230, 150, Math.round(55 * glow)),
                            new Color(200, 160, 60, Math.round(25 * glow)),
                            new Color(0, 0, 0, 0)
                    });
            g2.setPaint(bloom);
            g2.fillOval(cx - (int) (w * 0.35), cy - (int) (h * 0.35), (int) (w * 0.7), (int) (h * 0.7));

            AffineTransform old = g2.getTransform();
            g2.translate(cx, cy);
            g2.rotate(angle);

            Stroke thin = new BasicStroke(1.6f);
            Stroke thick = new BasicStroke(4.5f);
            double[] radii = {70, 105, 145, 190};
            for (int i = 0; i < radii.length; i++) {
                double r = radii[i];
                float alpha = 0.35f + 0.15f * i;
                g2.setStroke(i % 2 == 0 ? thick : thin);
                g2.setColor(new Color(GOLD.getRed(), GOLD.getGreen(), GOLD.getBlue(), Math.round(255 * alpha * glow)));
                g2.draw(new Ellipse2D.Double(-r, -r, r * 2, r * 2));

                // Orbit diamonds
                for (int k = 0; k < 4; k++) {
                    double a = angle * (i % 2 == 0 ? 1.4 : -1.1) + k * Math.PI / 2;
                    double dx = Math.cos(a) * r;
                    double dy = Math.sin(a) * r;
                    drawDiamond(g2, dx, dy, 5 + i);
                }
            }

            g2.setTransform(old);

            // Center "A" mark
            g2.setFont(new Font("SansSerif", Font.BOLD, 54));
            FontMetrics fm = g2.getFontMetrics();
            String mark = "A";
            int tw = fm.stringWidth(mark);
            g2.setColor(new Color(255, 240, 180, 40));
            g2.drawString(mark, cx - tw / 2 + 2, cy + fm.getAscent() / 2 - 6 + 2);
            g2.setColor(GOLD);
            g2.drawString(mark, cx - tw / 2, cy + fm.getAscent() / 2 - 6);
        }

        private void drawDiamond(Graphics2D g2, double x, double y, double size) {
            Path2D p = new Path2D.Double();
            p.moveTo(x, y - size);
            p.lineTo(x + size * 0.7, y);
            p.lineTo(x, y + size);
            p.lineTo(x - size * 0.7, y);
            p.closePath();
            g2.setColor(GOLD);
            g2.fill(p);
        }
    }
}
