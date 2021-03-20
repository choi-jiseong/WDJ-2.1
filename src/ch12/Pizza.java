package ch12;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Pizza extends JFrame {
   menu1 me=new menu1();
   menu2 me2=new menu2();
   menu3 me3=new menu3();
   JButton b1=new JButton("주문");
   JButton b2=new JButton("취소");
   JTextField t1=new JTextField(5);
   public Pizza() {
      JPanel pa=new JPanel();
      b1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            JButton ka=(JButton)e.getSource();
            if(ka==b1) {
               t1.setText(String.valueOf(me.temp+me2.temp+me3.temp));
            System.out.println("ddddd");
            }
            
         }
      });
      pa.add(b1);
      pa.add(b2);
      pa.add(t1);
      this.add(pa,BorderLayout.SOUTH);
      JLabel la=new JLabel("                       자바 나라에 온신것을 환영 합니다");
      //la.set
      this.add(la,BorderLayout.NORTH);
      this.add(me3,BorderLayout.EAST);
      this.add(me2,BorderLayout.CENTER);
      this.add(me,BorderLayout.WEST);
      this.setSize(500,300);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true);
   }

   public static void main(String[] args) {
      new Pizza();

   }
class menu1 extends JPanel implements ChangeListener{
   JRadioButton small,medium,large;
   ButtonGroup g1;
   int temp=0;
   public menu1() {
      small=new JRadioButton("small",true);
      g1=new ButtonGroup();
      g1.add(small);
      small.addChangeListener(this);
      medium=new JRadioButton("mesium");
      g1.add(medium);
      medium.addChangeListener(this);
      large=new JRadioButton("large");
      g1.add(large);
      large.addChangeListener(this);
      
      this.setLayout(new GridLayout(0,1));
      this.add(small);
      this.add(medium);
      this.add(large);
      this.setBorder(BorderFactory.createTitledBorder("크기"));
   }
   @Override
   public void stateChanged(ChangeEvent e) {
      JRadioButton ja=(JRadioButton)e.getSource();
      if(ja==small) {
         temp=10000;
         System.out.println("qqqqqqqq");
      }
      else if(ja==medium) {
         temp=15000;
      }else temp=18000;
      
   }
}
class menu2 extends JPanel implements ChangeListener{
   JRadioButton pimag,pepe,tomato,be;
   ButtonGroup g1;
   int temp=0;
   public menu2() {
      g1=new ButtonGroup();
      pimag=new JRadioButton("피망",true);
      g1.add(pimag);
      pimag.addChangeListener(this);
      pepe=new JRadioButton("페페로니");
      g1.add(pepe);
      tomato=new JRadioButton("토마토");
      tomato.addChangeListener(this);
      g1.add(tomato);
      be=new JRadioButton("베이컨");
      g1.add(be);
      be.addChangeListener(this);
      
      this.setLayout(new GridLayout(0,1));
      this.add(pimag);
      this.add(pepe);
      this.add(tomato);
      this.add(be);
      
      this.setBorder(BorderFactory.createTitledBorder("추가토핑"));
   }
   @Override
   public void stateChanged(ChangeEvent e) {
      JRadioButton ja=(JRadioButton)e.getSource();
      if(ja==pimag) {
         temp=3000;
      }
      else if(ja==pepe) {
         temp=2000;
      }else if (ja==tomato) {
         temp=3000;
      }else temp=4000;
      
   }
}
class menu3 extends JPanel implements ChangeListener{
   JRadioButton combo,poteto,gogi;
   ButtonGroup g1;
   int temp=0;
   public menu3() {
      combo=new JRadioButton("콤보",true);
      g1=new ButtonGroup();
      combo.addChangeListener(this);
      g1.add(combo);
      poteto=new JRadioButton("포테이토");
      poteto.addChangeListener(this);
      g1.add(poteto);
      gogi=new JRadioButton("불고기");
      g1.add(gogi);
      gogi.addChangeListener(this);
      this.setLayout(new GridLayout(0,1));
      this.add(combo);
      this.add(poteto);
      this.add(gogi);
      
      this.setBorder(BorderFactory.createTitledBorder("종류"));
   }
   @Override
   public void stateChanged(ChangeEvent e) {
      JRadioButton ja=(JRadioButton)e.getSource();
      if(ja==combo) {
         temp=3000;
      }
      else if(ja==poteto) {
         temp=4000;
      }else temp=2000;
      
   }
}

}
