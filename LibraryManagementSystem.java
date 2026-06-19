interface Lendable {
    void checkout(String borrowerName);

    default void inspection() {
        System.out.println("[Lendable Audit] Checking physical condition for tear/wear.");
    }
}

interface Archivable {
    void digitize();

    default void inspection() {
        System.out.println("[Archive Audit] Verifying historical authenticity and preservation status.");
    }
}

abstract class LibraryResource {
    protected String resourceId;
    protected String title;

    public LibraryResource(String resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
    }

    public LibraryResource(String title) {
        this("LIB-" + (int)(Math.random() * 5000), title);
    }

    abstract void locate();

    final void printLabel() {
        System.out.println("\n--- LIBRARY LABEL ---");
        System.out.println("ID: " + this.resourceId);
        System.out.println("Title: " + this.title.toUpperCase());
        System.out.println("---------------------");
    }

    static void libraryHours() {
        System.out.println("\n[NOTICE] Library is open from 9:00 AM to 8:00 PM.");
    }
}

class Librarian {
    public void processRequest(LibraryResource res) {
        System.out.println("Librarian: Processing " + res.title + " (Standard Check).");
    }

    public void processRequest(LibraryResource res, boolean isPriority) {
        String p = isPriority ? "High Priority" : "Standard";
        System.out.println("Librarian: Processing " + res.title + " with " + p + " status.");
    }

    public void processRequest(LibraryResource res, int days) {
        System.out.println("Librarian: Issuing " + res.title + " for " + days + " days.");
    }
}

class TextBook extends LibraryResource implements Lendable {

    public TextBook(String title) {
        super(title);
    }

    @Override
    void locate() {
        System.out.println("Location: 2nd Floor, Aisle 4 (General Section).");
    }

    @Override
    public void checkout(String borrowerName) {
        System.out.println("Book issued to: " + borrowerName);
    }

    @Override
    public void inspection() {
        System.out.print("TextBook Check: ");
        Lendable.super.inspection();
    }
}

class RareManuscript extends LibraryResource implements Lendable, Archivable {

    public RareManuscript(String id, String title) {
        super(id, title);
    }

    @Override
    void locate() {
        System.out.println("Location: Basement Vault (Restricted Access).");
    }

    @Override
    public void checkout(String borrowerName) {
        System.out.println("Special permission granted. Issued to researcher: " + borrowerName);
    }

    @Override
    public void digitize() {
        System.out.println("Scanning pages for digital archive...");
    }

    @Override
    public void inspection() {
        System.out.println("--- Comprehensive Inspection for Rare Item ---");
        Lendable.super.inspection(); 
        Archivable.super.inspection();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryResource.libraryHours();

        TextBook javaBook = new TextBook("Intro to Java Programming");
        RareManuscript oldScroll = new RareManuscript("HIST-999", "Ancient Roman Scrolls");

        LibraryResource item1 = javaBook;
        LibraryResource item2 = oldScroll;

        item1.printLabel();
        item2.printLabel();

        item1.locate();
        item2.locate();

        Lendable lendRef = javaBook;
        lendRef.inspection();

        Archivable archiveRef = oldScroll;
        archiveRef.inspection(); 

        Librarian desk = new Librarian();
        desk.processRequest(item1);
        desk.processRequest(item2, true);
        desk.processRequest(item1, 14);
    }
}