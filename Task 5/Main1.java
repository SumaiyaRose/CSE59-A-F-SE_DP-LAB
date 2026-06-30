
interface Printer {
    void printDocument();
}


interface Scanner {
    void scanDocument();
}


interface FaxMachine {
    void faxDocument();
}


class MultiFunctionCopier implements Printer, Scanner, FaxMachine {

    
    public void printDocument() {
        System.out.println("Printing...");
    }

    
    public void scanDocument() {
        System.out.println("Scanning...");
    }

    
    public void faxDocument() {
        System.out.println("Faxing...");
    }
}


class BasicPrinter implements Printer {

    
    public void printDocument() {
        System.out.println("Printing...");
    }
}


public class Main1 {

    public static void main(String[] args) {

        // Create a BasicPrinter object
        BasicPrinter basicPrinter = new BasicPrinter();
        System.out.println("Basic Printer:");
        basicPrinter.printDocument();

        System.out.println();

        // Create a MultiFunctionCopier object
        MultiFunctionCopier copier = new MultiFunctionCopier();
        System.out.println("MultiFunction Copier:");
        copier.printDocument();
        copier.scanDocument();
        copier.faxDocument();
    }
}
