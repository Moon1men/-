import java.awt.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.event.*;
import javax.swing.JFileChooser.*;
import javax.swing.filechooser.*;
import javax.imageio.ImageIO.*;
import java.awt.image.*;

public class FractalExplorer 
{

    private JButton saveButton;
    private JButton resetButton;
    private JComboBox myComboBox;
    
    private int rowsRemaining;

    private int display_size;
    
    private JImageDisplay display;

    private FractalGenerator fractal;
    
    private Rectangle2D.Double range;

    public FractalExplorer(int size)

    {
        display_size = size; 
        fractal = new Mandelbrot();
        range = new Rectangle2D.Double();
        fractal.getInitialRange(range);
        display = new JImageDisplay(display_size, display_size);
    }
    

    public void createAndShowGUI()
    {
        display.setLayout(new BorderLayout());
        JFrame frame = new JFrame("Fractal Explorer");
        frame.add(display, BorderLayout.CENTER);
    
        JButton resetButton = new JButton("Reset");
        frame.add(resetButton, BorderLayout.SOUTH);
        ButtonHandler resetHandler = new ButtonHandler();
        resetButton.addActionListener(resetHandler);
    
        MouseHandler click = new MouseHandler();
        display.addMouseListener(click);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox myComboBox = new JComboBox();

        FractalGenerator mandelbrotFractal = new Mandelbrot();
        myComboBox.addItem(mandelbrotFractal);
        FractalGenerator tricornFractal = new Tricorn();
        myComboBox.addItem(tricornFractal);
        FractalGenerator burningShipFractal = new BurningShip();
        myComboBox.addItem(burningShipFractal);
    
        ButtonHandler fractalChooser = new ButtonHandler();
        myComboBox.addActionListener(fractalChooser);

        JPanel myPanel = new JPanel();
        JLabel myLabel = new JLabel("Fractal:");
        
        myPanel.add(myLabel);
        myPanel.add(myComboBox);
        frame.add(myPanel, BorderLayout.NORTH);

        JButton saveButton = new JButton("Save");
        JPanel myBottomPanel = new JPanel();
        myBottomPanel.add(saveButton);
        myBottomPanel.add(resetButton);
        frame.add(myBottomPanel, BorderLayout.SOUTH);

        ButtonHandler saveHandler = new ButtonHandler();
        saveButton.addActionListener(saveHandler);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }   


    private void drawFractal()
    {
        rowsRemaining = display_size;

        for (int x=0; x<display_size; x++) {
            FractalWorker drawRow = new FractalWorker(x);
            drawRow.execute();
        } 
        enableUI(false);
    }
    
    private void enableUI(boolean val) {
        myComboBox.setEnabled(val);
        resetButton.setEnabled(val);
        saveButton.setEnabled(val);
    }

    public class ButtonHandler implements ActionListener 
    {
	    @Override
	    public void actionPerformed(ActionEvent e)
        {
            String command = e.getActionCommand();
 
            if (e.getSource() instanceof JComboBox) {
                JComboBox mySource = (JComboBox) e.getSource();
                fractal = (FractalGenerator) mySource.getSelectedItem();
                fractal.getInitialRange(range);
                drawFractal();    
            }
        
            else if (command.equals("Reset"))
            {
                fractal.getInitialRange(range);
                drawFractal();
            } 
            else if (command.equals("Save"))
            {
            JFileChooser myFileChooser = new JFileChooser();
            FileFilter extensionFilter = new FileNameExtensionFilter("PNG Images", "png");
            myFileChooser.setFileFilter(extensionFilter);

            myFileChooser.setAcceptAllFileFilterUsed(false);

            int userSelection = myFileChooser.showSaveDialog(display);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File file = myFileChooser.getSelectedFile();
                String file_name = file.toString();
                try {
                    BufferedImage displayImage = display.getImage();
                    javax.imageio.ImageIO.write(displayImage, "png", file);
                    }
                catch (Exception exception) {
                    JOptionPane.showMessageDialog(display,
                    exception.getMessage(), "Cannot Save Image",
                    JOptionPane.ERROR_MESSAGE);
                    }
            }
            else return;
        } 
    }
} 
    private  class MouseHandler extends MouseAdapter
    {
        @Override
        public void mouseClicked (MouseEvent e)
        {
            int x = e.getX();
            double xCoord = fractal.getCoord(range.x, range.x + range.width, display_size, x);
            int y = e.getY();
            double yCoord = fractal.getCoord(range.y,range.y + range.height, display_size, y);
            fractal.recenterAndZoomRange(range, xCoord, yCoord, 0.5);

            drawFractal();
        }
    }
   private class FractalWorker extends SwingWorker<Object, Object>
    {
        int yCoordinate;
        int[] computedRGBValues;
        private FractalWorker(int row) {
            yCoordinate = row;
        }

        protected Object doInBackground() {
            computedRGBValues = new int[display_size];

             for (int i = 0; i < computedRGBValues.length; i++)
             {
            
            double xCoord = fractal.getCoord(range.x,range.x + range.width, display_size, i);
            double yCoord = fractal.getCoord(range.y,range.y + range.height, display_size, yCoordinate);
            
            int iteration = fractal.numIterations(xCoord, yCoord);
             if (iteration == -1){
                    computedRGBValues[i] = 16777215;
                }
            
                else {
                    float hue = (float) iteration / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    computedRGBValues[i] = rgbColor;
                }
            }
            return null;
        }
        protected void done() {
         for (int i = 0; i < computedRGBValues.length; i++) {
                display.drawPixel(i, yCoordinate, computedRGBValues[i]);
            }
            display.repaint(0, 0, yCoordinate, display_size, 1);
            rowsRemaining--;
            if (rowsRemaining == 0) {
                enableUI(true);
            }
        }
    }
   public static void main(String[] args)
    {
        FractalExplorer displayExplorer = new FractalExplorer(800);
        displayExplorer.createAndShowGUI();
        displayExplorer.drawFractal();
    }
}
