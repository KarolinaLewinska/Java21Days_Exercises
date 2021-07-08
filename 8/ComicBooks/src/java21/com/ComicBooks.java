package java21.com;

import java.util.HashMap;

public class ComicBooks {
    public static void main(String[] args) {
        HashMap quality = new HashMap();
        float price1 = 3.00F;
        quality.put(bookCondition.JAK_NOWY, price1);
        
        float price2 = 2.00F;
        quality.put(bookCondition.PRAWIE_JAK_NOWY, price2);
        
        float price3 = 1.50F;
        quality.put(bookCondition.BARDZO_DOBRY, price3);
        
        float price4 = 1.00F;
        quality.put(bookCondition.DOBRY, price4);
        
        float price5 = 0.50F;
        quality.put(bookCondition.SREDNI, price5);
        
        float price6 = 0.25F;
        quality.put(bookCondition.SLABY, price6);
        
        float price7 = 5.00F;
        quality.put(bookCondition.CALKOWICIE_NOWY, price7);
        
        float price8 = 0.10F;
        quality.put(bookCondition.BEZ_OKLADKI, price8);
        
        Comic[] comix = new Comic[3];
        comix[0] = new Comic("Wspaniały Spider-Man", "1A", bookCondition.BARDZO_DOBRY, 12_000.00F);
        comix[0].setPrice((Float) quality.get(comix[0].condition));
        
        comix[1] = new Comic("Niesamowity Hulk", "181", bookCondition.PRAWIE_JAK_NOWY, 680.00F);
        comix[1].setPrice((Float) quality.get(comix[1].condition));
        
        comix[2] = new Comic("Cerebus", "1A", bookCondition.SREDNI, 190.00F);
        comix[2].setPrice((Float) quality.get(comix[2].condition));
        
        for (int i = 0; i < comix.length; i++) {
            System.out.println("Tytuł: " + comix[i].title);
            System.out.println("Numer: " + comix[i].issueNumber);
            System.out.println("Stan: " + comix[i].condition);
            System.out.println("Cena: " + comix[i].price + "zł\n");
    
        }   
    }
}

class Comic {
    bookCondition condition;
    String title, issueNumber;
    float basePrice, price;

    Comic(String inTitle, String inIssueNumber, bookCondition inCondition, float inBasePrice) {
        this.title = inTitle;
        this.issueNumber = inIssueNumber;
        this.condition = inCondition;
        this.basePrice = inBasePrice;
    }

    void setPrice(float factor) {
        price = basePrice * factor;
    }
}

enum bookCondition {
    CALKOWICIE_NOWY,
    JAK_NOWY,
    PRAWIE_JAK_NOWY,
    BARDZO_DOBRY,
    DOBRY,
    SREDNI,
    SLABY,
    BEZ_OKLADKI
}
