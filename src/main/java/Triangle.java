public class Triangle {
    double base;
    double height;
    double sideLenOne;
    double sideLenTwo;
    double sidelenThree;

    public Triangle(double base,double height,double sideLenOne,double sideLenTwo,double sidelenThree){
        this.base=base;
        this.height=height;
        this.sideLenOne=sideLenOne;
        this.sideLenTwo=sideLenTwo;
        this.sidelenThree=sidelenThree;

    }public double findArea(){
        return(this.base*this.height)/2;
    }
}
