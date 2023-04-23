package Project;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
public class CustomPanel extends JPanel{
    int p=0;
    public void UpdateProgress(int progress){
        p=progress;
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.translate(this.getWidth()/2, this.getHeight()/2);
        g2.rotate(Math.toRadians(-90));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        Ellipse2D circle = new Ellipse2D.Float(0,0,36,36);
        arc.setFrameFromCenter(new Point(0,0),new Point(40,40));
        circle.setFrameFromCenter(new Point(0,0),new Point(36,36));
        arc.setAngleStart(1);
        arc.setAngleExtent(-p*3.6);
        g2.setColor(Color.decode("#0098a3"));
        g2.fill(arc);
        g2.setColor(Color.white);
        g2.fill(circle);
        g2.setColor(Color.decode("#0098a3"));
        g.setFont(new Font("Verdana",Font.PLAIN,18));
        FontMetrics fn = g2.getFontMetrics();
        Rectangle2D r = fn.getStringBounds(p+"",g);
        int x=(-(int)r.getWidth())/2;
        int y=(-(int)r.getHeight()/2)+fn.getAscent();
        g2.rotate(Math.toRadians(90));
        g2.drawString(p+"%",(float)(x-5),y);
    }
}
