import java.util.ArrayList;
import java.util.Random;

public class DominoPile {
    ArrayList<Domino> pile = new ArrayList<>();

    public DominoPile(){
        pile.clear();
    }

    public void newStack6(){
        ArrayList<Domino> newpile = new ArrayList<>();
        for (int i=0; i<=6; i++){
            for (int j=0; j<=6; j++){
                Domino d = new Domino(i,j);
                newpile.add(d);
            }
        }


        for (int i=0; i<newpile.size(); i++){
            Domino d = newpile.get(i);
            boolean alrexists = false;
            for (Domino x: pile){
                x.flip();
                if (d.compareTo(x)==0) alrexists=true;
                x.flip();
                if (alrexists) break;
            }
            if (!alrexists) pile.add(d);
        }

        for (Domino d: pile){
            if (d.getTop() > d.getBottom()) d.flip();
        }

    }

    public void shuffle(){
        Random rand = new Random();
        ArrayList<Integer> new_indexes = new ArrayList<>();
        for (int i=0; i<pile.size(); i++){
            new_indexes.add(rand.nextInt(pile.size()));
        }
        ArrayList<Domino> shuffeled = new ArrayList<>();
        for (int i=0; i<pile.size(); i++){
            shuffeled.add(pile.get(new_indexes.get(i)));
        }
        pile=shuffeled;


    }

    public ArrayList<Domino> getPile(){
        return pile;
    }



}
