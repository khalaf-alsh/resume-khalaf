import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {
    public JFrame mainFrame;
    public Map<String, String[]> optionsMap;
    public Map<String, RestaurantInfo> restaurantMap;

    private static class RestaurantInfo {
        private final String name;
        private final String imageUrl;
        private final double quality;
        private final double service;
        private final String vibe;
        private final double overallScore;

        public RestaurantInfo(String name, String imageUrl, double quality, double service, String vibe) {
            this.name = name;
            this.imageUrl = imageUrl;
            this.quality = quality;
            this.service = service;
            this.vibe = vibe;
            this.overallScore = calculateOverallScore();
        }

        public String getName() {
            return name;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public double getQuality() {
            return quality;
        }

        public double getService() {
            return service;
        }

        public String getVibe() {
            return vibe;
        }

        public double getOverallScore() {
            return overallScore;
        }

        private double calculateOverallScore() {
            double qualityWeight = 0.4;
            double serviceWeight = 0.3;
            double vibeWeight = 0.3;
            return (qualityWeight * quality) + (serviceWeight * service) + (vibeWeight * convertVibeToScore(vibe));
        }

        private double convertVibeToScore(String vibe) {
            return switch (vibe.toLowerCase()) {
                case "cozy" -> 4.5;
                case "energetic" -> 4.0;
                case "relaxed" -> 4.3;
                case "friendly" -> 4.2;
                case "modern" -> 4.7;
                case "charming" -> 4.4;
                case "lively" -> 4.6;
                case "casual" -> 4.9;
                case "relaxing" -> 4.3;
                case "vibrant" -> 4.1;
                default -> 0.0;
            };
        }
    }

    public Main() {

        optionsMap = new HashMap<>();
        optionsMap.put("North", new String[]{ "المنؤوشة ١", "بوقا", "ماكدونالدز", "بيتزا هت ٤","البيك ١", "البيك ٢","البيك ٤","البيك ٣", "كنتاكي", "صب واي ٤", "بيتزا هت ٣","البيك ٥" , "كنتاكي" , "هارديز ٢", "المشوي العنابي ٢", "ليشلازر ١", "بيتزا هت ٦" , "صب واي ٥", "صب واي ٢", "صب واي ٣",   "ليشلازر ٢" , "كتكيت", "كشري ابو طارق", "المشوي العنابي ١", "بيتوتي"}  );
        optionsMap.put("South", new String[]{"كنتاكي"});
        optionsMap.put("West", new String[]{"هارديز ٢", "المشوي العنابي ٢", "ليشلازر ١", "بيتزا هت ٦"});
        optionsMap.put("East", new String[]{"صب واي ٥", "صب واي ٢", "صب واي ٣", "ليشلازر ٢"});


        restaurantMap = new HashMap<>();
        restaurantMap.put("المنؤوشة ١", new RestaurantInfo("المنؤوشة ١", "src/img.png", 3.8, 3.5, "Relaxed"));
        restaurantMap.put("بوقا", new RestaurantInfo("بوقا", "src/img.png", 4.0, 4.2, "Casual"));
        restaurantMap.put("ماكدونالدز", new RestaurantInfo("ماكدونالدز", "src/img.png", 3.9, 3.8, "Friendly"));
        restaurantMap.put("بيتزا هت ٤", new RestaurantInfo("بيتزا هت ٤", "src/img.png", 4, 4.8, "Unknown"));
        restaurantMap.put("البيك ١", new RestaurantInfo("البيك ١", "src/img.png", 4.1, 4.3, "Casual"));
        restaurantMap.put("البيك ٢", new RestaurantInfo("البيك ٢", "src/img.png", 3.5, 4.0, "Casual"));
        restaurantMap.put("البيك ٣", new RestaurantInfo("البيك ٣", "src/img.png", 4.4, 4.9, "Casual"));
        restaurantMap.put("البيك ٤", new RestaurantInfo("البيك ٤", "src/img.png", 4.2, 4.0, "Casual"));
        restaurantMap.put("البيك ٥", new RestaurantInfo("البيك ٥", "src/img.png", 4.0, 4.0, ""));
        restaurantMap.put("البيك ٦", new RestaurantInfo("البيك ٦", "src/img.png", 3.9, 4.0, "Casual"));
        restaurantMap.put("ليشلازر ١", new RestaurantInfo("ليشلازر ١", "src/img.png", 4.1, 4.4, "Casual"));
        restaurantMap.put("ليشلازر ٢", new RestaurantInfo("ليشلازر ٢", "src/img.png", 4.1, 4.0, "Casual"));
        restaurantMap.put("ليشلازر ٣", new RestaurantInfo("ليشلازر ٣", "src/img.png", 4.2, 4.5, "Casual"));
        restaurantMap.put("المشوي العنابي ١", new RestaurantInfo("المشوي العنابي ١", "src/img.png", 3.9, 4.1, "Casual"));
        restaurantMap.put("المشوي العنابي ٢", new RestaurantInfo("المشوي العنابي ٢", "src/img.png", 4.1, 4.2, "Casual"));
        restaurantMap.put("سنشري برجر", new RestaurantInfo("سنشري برجر", "src/img.png",  4.1, 4.0, "Casual"));
        restaurantMap.put("صب واي ١", new RestaurantInfo("صب واي ١", "src/img.png", 4.2, 4.0, "Casual"));
        restaurantMap.put("صب واي ٢", new RestaurantInfo("صب واي ٢", "src/img.png", 4.4, 4.0, "Casual"));
        restaurantMap.put("صب واي ٣", new RestaurantInfo("صب واي ٣", "src/img.png", 3.8, 4.0, "Casual"));
        restaurantMap.put("صب واي ٤", new RestaurantInfo("صب واي ٤", "src/img.png", 3.4, 3.5, "Casual"));
        restaurantMap.put("صب واي ٥", new RestaurantInfo("صب واي ٥", "src/img.png", 4.9, 4.8, "Casual"));
        restaurantMap.put("كشري ابو طارق", new RestaurantInfo("كشري ابو طارق", "src/img.png", 4.0, 4.0, "Casual"));
        restaurantMap.put("بيتوتي", new RestaurantInfo("بيتوتي", "src/img.png", 3.3, 3.0, "Casual"));
        restaurantMap.put("هارديز ١", new RestaurantInfo("هارديز ١", "src/img.png", 4.0, 3.8, "Casual"));
        restaurantMap.put("هارديز ٢", new RestaurantInfo("هارديز ٢", "src/img.png", 4.7, 4.5, "Casual"));
        restaurantMap.put("هارديز ٣", new RestaurantInfo("هارديز ٣", "src/img.png", 3.2, 3.0, "Casual"));
        restaurantMap.put("بيتزا هت ١", new RestaurantInfo("بيتزا هت ١", "src/img.png", 3.9, 4.0, "Casual"));
        restaurantMap.put("بيتزا هت ٢", new RestaurantInfo("بيتزا هت ٢", "src/img.png", 3.6, 4.0, "Casual"));

        // Add more restaurants and their details here similarly...
        ImageIcon image = new ImageIcon("src/logo1.png");

        mainFrame = new JFrame("Jeddah Restaurants Guide ");
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(new Color(255, 155, 255));
        mainFrame.setIconImage(image.getImage());


        JRadioButton northButton = new JRadioButton("North");
        JRadioButton southButton = new JRadioButton("South");
        JRadioButton westButton = new JRadioButton("West");
        JRadioButton eastButton = new JRadioButton("East");
//        JRadioButton jeddahButton = new JRadioButton("Jeddah");

        ButtonGroup directionGroup = new ButtonGroup();
        directionGroup.add(northButton);
        directionGroup.add(southButton);
        directionGroup.add(westButton);
        directionGroup.add(eastButton);


        JPanel directionPanel = new JPanel();
        directionPanel.setLayout(new GridLayout(5, 1));
        directionPanel.add(northButton);
        directionPanel.add(southButton);
        directionPanel.add(westButton);
        directionPanel.add(eastButton);
//        directionPanel.add(jeddahButton);

        JComboBox<String> optionComboBox = new JComboBox<>();
        optionComboBox.setPreferredSize(new Dimension(200, 30));

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new FlowLayout());
        optionPanel.add(new JLabel("Select an option:"));
        optionPanel.add(optionComboBox);

        JButton viewDetailsButton = new JButton("View Details");
        optionPanel.add(viewDetailsButton);

        mainFrame.add(directionPanel, BorderLayout.WEST);
        mainFrame.add(optionPanel, BorderLayout.CENTER);
        mainFrame.setLocationRelativeTo(null);

        northButton.addActionListener(e -> populateOptions("North", optionComboBox));
        southButton.addActionListener(e -> populateOptions("South", optionComboBox));
        westButton.addActionListener(e -> populateOptions("West", optionComboBox));
        eastButton.addActionListener(e -> populateOptions("East", optionComboBox));
//        jeddahButton.addActionListener(e -> populateOptions("Jeddah", optionComboBox));

        viewDetailsButton.addActionListener(e -> {
            String selectedOption = (String) optionComboBox.getSelectedItem();
            if (selectedOption != null) {
                openNewWindow(selectedOption);
            }
        });

        mainFrame.setVisible(true);
    }

    private void populateOptions(String direction, JComboBox<String> optionComboBox) {
        optionComboBox.removeAllItems();
        String[] options = optionsMap.get(direction);
        if (options != null) {
            for (String option : options) {
                optionComboBox.addItem(option);
            }
        }
    }

    private void openNewWindow(String option) {
        RestaurantInfo restaurantInfo = restaurantMap.get(option);
        if (restaurantInfo != null) {
            JFrame newFrame = new JFrame(option);

            // Calculate dimensions for the new frame
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int frameWidth = screenSize.width / 2;  // Take half of the screen width
            int frameHeight = screenSize.height;

            newFrame.setSize(frameWidth, frameHeight);
            newFrame.setLayout(new BorderLayout());
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel detailsPanel = new JPanel();
            detailsPanel.setLayout(new GridLayout(5, 1));
            detailsPanel.setBackground(new Color(255, 255, 255));

            JLabel nameLabel = new JLabel("Restaurant: " + restaurantInfo.getName());
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            detailsPanel.add(nameLabel);

            JLabel qualityLabel = new JLabel("Quality of Food: " + restaurantInfo.getQuality());
            detailsPanel.add(qualityLabel);

            JLabel serviceLabel = new JLabel("Service: " + restaurantInfo.getService());
            detailsPanel.add(serviceLabel);

            JLabel vibeLabel = new JLabel("Vibe: " + restaurantInfo.getVibe());
            detailsPanel.add(vibeLabel);

            JLabel scoreLabel = new JLabel("Overall Score: ");
            JPanel starsPanel = new JPanel();
            starsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            starsPanel.setBackground(new Color(255, 255, 255));

            ImageIcon starIcon = new ImageIcon("src/star_icon.png");
            Image scaledStarImage = starIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            ImageIcon scaledStarIcon = new ImageIcon(scaledStarImage);

            for (int i = 0; i < (int) restaurantInfo.getOverallScore(); i++) {
                JLabel starLabel = new JLabel(scaledStarIcon);
                starsPanel.add(starLabel);
            }

            detailsPanel.add(scoreLabel);
            detailsPanel.add(starsPanel);

            // Create a new panel for the image
            JPanel imagePanel = new JPanel();
            imagePanel.setBackground(Color.WHITE);

            ImageIcon imageIcon = new ImageIcon(restaurantInfo.getImageUrl());
            Image scaledImage = imageIcon.getImage().getScaledInstance(frameWidth, frameHeight / 2, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledImageIcon);
            imagePanel.add(imageLabel);

            // Use JSplitPane to divide the frame
            JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, detailsPanel, imagePanel);
            splitPane.setDividerLocation(frameHeight / 2); // Set divider position for bottom panel

            newFrame.add(splitPane, BorderLayout.CENTER);
            newFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(mainFrame, "Restaurant information not available", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayWelcomeFrame() {
        JFrame welcomeFrame = new JFrame("Welcome to Jeddah Restaurants Guide");
        welcomeFrame.setSize(400, 200);
        welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Hello, Welcome to Jeddah Restaurants Guide");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton continueButton = new JButton("Continue");
        continueButton.addActionListener(e -> {
            welcomeFrame.dispose(); // Close the welcome frame
            setupMainFrame(); // Initialize and display the main application frame
        });

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        welcomePanel.add(continueButton, BorderLayout.SOUTH);

        welcomeFrame.add(welcomePanel);
        welcomeFrame.setLocationRelativeTo(null); // Center the frame on screen
        welcomeFrame.setVisible(true);
    }

    private void setupMainFrame() {
        mainFrame = new JFrame("Jeddah Restaurants Guide");
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // Add your main application content here (e.g., optionsPanel, etc.)

        mainFrame.setLocationRelativeTo(null); // Center the frame on screen
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {

        MyFrame myFrame = new MyFrame();
    }
}