public class Domino {
    private int top;
    private int bottom;

    public Domino(){
        top=0;
        bottom=0;
    }

    public Domino(int t, int b){
        top=t;
        bottom=b;
    }

    public String toString(){
        return top + "\\" + bottom;

    }

    public int getTop(){return top;}
    public int getBottom(){return bottom;}
    public void setTop(int t){top=t;}
    public void setBottom(int b){bottom=b;};


    public void flip(){
        int temp = top;
        top = bottom;
        bottom = temp;
    }

    public void settle(){
        if (top>bottom){
            flip();
        }
    }

    public int compareTo(Domino other){
        this.settle();
        other.settle();

        if (this.top < other.top) return -1;
        if (this.top > other.top) return 1;
        else{
            if (this.bottom < other.bottom) return -1;
            if (this.bottom > other.bottom) return 1;
            else return 0;
        }
    }

    public int compareToWeight(Domino other){
        int thisTotal = this.top + this.bottom;
        int otherTotal = other.top + other.bottom;
        if (thisTotal<otherTotal) return -1;
        if (thisTotal>otherTotal) return 1;
        else return 0;
    }

    public boolean canConnect(Domino other){
        if (this.top==other.top) return true;
        else if (this.top==other.bottom) return true;
        else if (this.bottom==other.top) return true;
        else if (this.bottom==other.bottom) return true;
        else return false;
    }

}
