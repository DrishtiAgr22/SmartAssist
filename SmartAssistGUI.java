package com.company;

import javax.swing.*;//main library
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.text.SimpleDateFormat;

class Assist extends JFrame {
    JTextArea ta = new JTextArea();
     JTextField tf = new JTextField();

    JButton b = new JButton();

     JLabel label = new JLabel();
     JLabel label1 = new JLabel();
     JLabel label2 = new JLabel();
     JLabel label3 = new JLabel();
     JWindow window=new JWindow();
     JLabel label4=new JLabel();


    Assist() {

        JFrame frame = new JFrame();

        ImageIcon img1=new ImageIcon(getClass().getResource("p2.gif"));


        JLabel l2=new JLabel(img1);

        //Splash screen

        window.add(l2);
        l2.setLocation(1,1);
        l2.setSize(354,368);

        window.add(l2);
        window.setVisible(true);
        window.setLocation(400,140);
        window.setSize(800 ,400);
        try
        {
            Thread.sleep(5000);
        }
        catch (Exception a2)
        {
            a2.printStackTrace();
        }
        window.dispose();
        JLayeredPane layeredPane=new JLayeredPane();
        layeredPane.setBounds(0,0,820,800);//layered pane size
        frame.add(layeredPane);//adding layered pane to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setBackground(new Color(248,160,38,255));//layered background color (rgba code)

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);


        frame.setSize(1020, 800);
        frame.setLocation(400,20);
        label.setBounds(0,0,800,800);

        ta.setForeground(Color.gray);

        frame.setTitle(("SmartAssist"));

        frame.add(ta);
        frame.add(tf);

        tf.setBackground(Color.white);
        ta.setSize(1000, 410);
        ta.setLocation(1, 1);
        ta.setBackground(Color.white);
        ta.setFont(new Font("Times new roman",Font.PLAIN,28));


        tf.setSize(800, 40);

        tf.setFont(new Font("Times new roman",Font.PLAIN,20));

        tf.setLocation(40, 600);
        frame.add(b);
        label.setText("  Enter");
        label.setFont(new Font("Times new roman",Font.BOLD,20));
        label.setLocation(1000,597);
        b.add(label);
        tf.setBackground(Color.white);
        b.setSize(100, 40);
        b.setLocation(880, 597);

        ImageIcon img=new ImageIcon(getClass().getResource("pic14.png"));//TO IMPORT IMAGE OF DIRECTORY

        JLabel l3=new JLabel(img);
        l3.setSize(586,151);//SET SIZE OF LOGO
        l3.setSize(585,150);
        l3.setLocation(200,420);//SET POSITION OF LOGO ON FRAME
        frame.add(l3);

        JScrollPane bar=new JScrollPane(ta);
        bar.setSize(1000,410);

        frame.add(bar);
        ImageIcon imag=new ImageIcon(getClass().getResource("p4.png"));
        frame.setIconImage(imag.getImage());//TO SET ICON OF THE WINDOW


      b.addActionListener(new ActionListener() {





           public void actionPerformed(ActionEvent e)
            {
                int d = 1;
                int ch;
                int c = 0;
                int j;
                int f;
                int w;
                int s;
                int n = 0;
                Scanner s1 = new Scanner(System.in);
                Scanner s2 = new Scanner(System.in);

                Desktop de = Desktop.getDesktop();//TO ACCESS BROWSER
                SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss EE");
                Date date = new Date();

                if(e.getSource()==b) {
                    String text = tf.getText().toLowerCase();//TO CONVERT TEXT TO LOWERCASE
                    GregorianCalendar time = new GregorianCalendar();
                    int hours = time.get(Calendar.HOUR_OF_DAY);//USED FOR GREETINGS

                    ta.append("\n  You--> " + text + "\n");
                    tf.setText("");
                    if (text.contains("hi") || text.contains("Hi")) {
                        if (hours >= 05 && hours < 12)
                            reply("Good Morning!");
                        else if (hours >= 12 && hours <= 16)
                            reply("Good Afternoon!");
                        else if (hours >= 17 && hours <= 20)
                            reply("Good Evening!");
                        reply("  Hi!\n  I am SmartAssist");
                    }


                    if (text.contains("my name is")) {
                        String st1 = text.substring(11);
                        reply("Heyy " + st1 + " !");
                    } else if (text.contains("search song")) {

                        String u = text.substring(12);
                        reply("Here are the results\n");
                        try {
                            de.browse(new URI("https://open.spotify.com/search/" + u.replaceAll("\\s", "%20")));
                        } catch (Exception a) {

                        }

                    } else if (text.contains("playlist")) {
                        reply("Here are the results\n");
                        try {
                            de.browse(new URI("https://open.spotify.com/genre/bollywood-popular"));
                        } catch (Exception a) {

                        }
                    } else if (text.contains("trending")) {
                        reply("Here are the results\n");
                        try {
                            de.browse(new URI("https://open.spotify.com/genre/section0JQ5DAnM3wGh0gz1MXnu3E"));
                        } catch (Exception a) {

                        }
                    } else if (text.contains("worldwide music")) {
                        reply("Here are the results\n");
                        try {
                            de.browse(new URI("https://open.spotify.com/genre/browse-charts-tab"));
                        } catch (Exception a) {

                        }
                    } else if (text.contains("date") || text.contains("time")) {
                        reply(dt.format(date));
                    } else if (text.contains("youtube")) {
                        reply("Here are the results\n");
                        try {
                            String st2 = text.substring(8);
                            de.browse(new URI("https://www.youtube.com/results?search_query=" + st2.replace(' ', '+')));
                        } catch (Exception b) {
                            System.out.println(b);
                        }
                    } else if (text.contains("google")) {
                        reply("Here are the results\n");
                        try {
                            String st = text.substring(7);
                            de.browse(new URI("https://www.google.com/search?q=" + st.replace(' ', '+')));

                        } catch (Exception a) {

                        }
                    } else if (text.contains("search")) {
                        reply("Here are the results");
                        try {
                            String st3 = text.substring(7);
                            de.browse(new URI("https://en.wikipedia.org/wiki/" + st3.replace(' ', '_')));

                        } catch (Exception a) {

                        }
                    } else if (text.contains("watch republic") || text.contains("watch republic tv")) {
                        reply("Here are the results\n");
                        try {
                            de.browse(new URI("https://www.youtube.com/watch?v=xtoOK86mW8Y"));

                        } catch (Exception a) {

                        }
                    } else if (text.contains("watch ndtv")) {
                        reply("Here are the results\n");
                        try {
                            de.browse(new URI("https://www.youtube.com/watch?v=WB-y7_ymPJ4"));

                        } catch (Exception a) {

                        }
                    } else if (text.contains("read news")) {
                        reply("Here are the results\n");
                        try {
                            String st5 = text.substring(10);
                            de.browse(new URI("https://www.hindustantimes.com/" + st5));

                        } catch (Exception a) {

                        }
                    } else if (text.contains("translate")) {
                        reply("Here are the results\n");
                        try {
                            String st6 = text.substring(10);

                            de.browse(new URI("https://www.google.com/search?q=translate+" + st6.replace(' ', '+') + "&rlz=1C1FHFK_enIN931IN931&oq=translate+&aqs=chrome.1.69i57j35i39j0i20i131i263i433i512j69i60l5.12711j1j4&sourceid=chrome&ie=UTF-8"));

                        } catch (Exception a) {

                        }
                    } else if (text.contains("fact")) {
                        Random rando = new Random();
                        f = 1 + rando.nextInt(4);

                        if (f == 1) {
                            reply("The strawberry is the only fruit that bears seeds on the outside");

                        }
                        if (f == 2) {
                            reply("The footprints on the moon will be there for 100 million years");
                        }

                        if (f == 3) {
                            reply("A bolt of lightning is five times hotter than the sun");
                        }
                        if (f == 4) {
                            reply("An ostrich's eye is bigger than its brain");
                        }
                    }

                    if (text.contains("How are you") || text.contains("how are you")) {
                        Random rando = new Random();
                        j = 1 + rando.nextInt(3);
                        if (j == 1)
                            reply("I am Fine!");
                        if (j == 2)
                            reply("I am Fine!,Thanks for asking!");
                        if (j == 3)
                            reply("Working perfectly!");
                        if (j == 4)
                            reply("Working perfectly as always!");
                    } else if (text.contains("joke")) {
                        Random rando = new Random();
                        int p = 1 + rando.nextInt(3);
                        if (p == 1) {

                            try {
                                new SwingWorker<String, String>() {
                                    protected String doInBackground() throws Exception {
                                        reply1("What did the left eye say to the right eye?");
                                        Thread.sleep(5000);
                                        return "";
                                    };

                                    protected void done() {
                                        reply1("Between You and me something smells");
                                    };
                                }.execute();//used for delay between joke and its answer

                            }catch (Exception e1){

                                e1.printStackTrace();
                            }

                        }
                        if (p == 2) {
                            try {
                                new SwingWorker<String, String>() {
                                    protected String doInBackground() throws Exception {
                                        reply1("What do you call a fish without eyes ?");
                                        Thread.sleep(5000);
                                        return "";
                                    };

                                    protected void done() {
                                        reply1("FSH");
                                    };
                                }.execute();

                            }catch (Exception e1){

                                e1.printStackTrace();
                            }



                        }
                        if (p == 3) {

                            try {
                                new SwingWorker<String, String>() {
                                    protected String doInBackground() throws Exception {
                                        reply1("Where are average things manufactured?");
                                        Thread.sleep(5000);
                                        return "";
                                    };

                                    protected void done() {
                                        reply1("The satisfactory");
                                    };
                                }.execute();

                            }catch (Exception e1){

                                e1.printStackTrace();
                            }

                        }
                        if (p == 4) {

                            try {
                                new SwingWorker<String, String>() {
                                    protected String doInBackground() throws Exception {
                                        reply1("What do you call a magic dog?");
                                        Thread.sleep(5000);
                                        return "";
                                    };

                                    protected void done() {
                                        reply1("A labracadabrador");
                                    };
                                }.execute();

                            }catch (Exception e1){

                                e1.printStackTrace();
                            }

                        }
                    }
                    else if(text.contains("shop"))
                    {
                        reply("Here are the results\n");
                        try {
                            String st8 = text.substring(5);

                            de.browse(new URI("https://www.amazon.in/s?k="+st8.replace(' ', '+')+"&ref=nb_sb_noss_2"));

                        } catch (Exception a) {

                        }
                    }
                    else if (text.contains("calculator"))
                    {
                        Runtime rt=Runtime.getRuntime();
                        try
                        {
                            rt.exec("calc");

                        } catch (Exception e1 ) {
                            e1.printStackTrace();
                        }
                    }

                }

                else{

                }
            }

        });
    }

    public void reply(String s) {
        ta.append("  SmartAssist--> " + s+"  \n\n");

       // ta.setText(ta.getText()+ "\n"+ "SmartAssist-->" + s + "\n");
        s=" ";
    }
    public void reply1(String s) {
        ta.append("  SmartAssist--> " + s + "  \n");
        // ta.setText(ta.getText()+ "\n"+ "SmartAssist-->" + s + "\n");
        s=" ";
    }

}
public class SmartAssistGUI
{
    public static void main(String args[]) {

        new Assist();

    }}


