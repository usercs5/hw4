import java.util.ArrayList;
import java.util.List;

public class FileSystemDemo {
    public static void main(String[] args) {
        // --- Setup the File System Structure ---
        Folder phpDemo1 = new Folder("php_demo1");

        // Source Files sub-tree
        Folder sourceFiles = new Folder("Source Files");
        sourceFiles.addSubFolder(new Folder("phalcon"));

        // App sub-folder and its contents
        Folder app = new Folder("app");
        app.addSubFolder(new Folder("config"));
        app.addSubFolder(new Folder("controllers"));
        app.addSubFolder(new Folder("library"));
        app.addSubFolder(new Folder("migrations"));
        app.addSubFolder(new Folder("models"));
        app.addSubFolder(new Folder("views"));
        sourceFiles.addSubFolder(app);

        sourceFiles.addSubFolder(new Folder("cache"));

        // Public sub-folder and its files
        Folder publicFolder = new Folder("public");
        publicFolder.addFile(new File(".htaccess"));
        publicFolder.addFile(new File(".htrouter.php"));
        publicFolder.addFile(new File("index.html"));
        sourceFiles.addSubFolder(publicFolder);

        phpDemo1.addSubFolder(sourceFiles);
        phpDemo1.addSubFolder(new Folder("Include Path"));
        phpDemo1.addSubFolder(new Folder("Remote Files"));

        // --- Step 1: Print initial structure ---
        System.out.println("==================================================");
        System.out.println("1. INITIAL FILE SYSTEM STRUCTURE");
        System.out.println("==================================================");
        phpDemo1.print();

        // --- Step 2: Delete folder 'app' and print structure ---
        System.out.println("\n==================================================");
        System.out.println("2. AFTER DELETING FOLDER 'app'");
        System.out.println("==================================================");
        phpDemo1.removeSubFolder("app");
        phpDemo1.print();

        // --- Step 3: Delete folder 'public' and print structure ---
        System.out.println("\n==================================================");
        System.out.println("3. AFTER DELETING FOLDER 'public'");
        System.out.println("==================================================");
        phpDemo1.removeSubFolder("public");
        phpDemo1.print();
        System.out.println("==================================================");
    }
}

// File Class
class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("[File] " + name);
    }
}

// Folder Class (Composition: Owns zero or more Files and Sub-Folders)
class Folder {
    private String name;
    private List<Folder> subFolders;
    private List<File> files;

    public Folder(String name) {
        this.name = name;
        this.subFolders = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getSubFolders() {
        return subFolders;
    }

    public List<File> getFiles() {
        return files;
    }

    public void addSubFolder(Folder folder) {
        subFolders.add(folder);
    }

    public void addFile(File file) {
        files.add(file);
    }

    // Recursively search and delete a sub-folder by name
    public boolean removeSubFolder(String targetName) {
        for (int i = 0; i < subFolders.size(); i++) {
            Folder f = subFolders.get(i);
            if (f.getName().equals(targetName)) {
                subFolders.remove(i); // Deleting the folder also deletes its contents (composition)
                return true;
            }
            if (f.removeSubFolder(targetName)) {
                return true;
            }
        }
        return false;
    }
    
    
// Print function that prints out all subfolders and files recursively with formatting
    public void print() {
        printRecursive("");
    }

    private void printRecursive(String indent) {
        System.out.println(indent + "[Folder] " + name);
        String nestedIndent = indent + "    ";
        
        for (File file : files) {
            System.out.print(nestedIndent);
            file.print();
        }
        
        for (Folder folder : subFolders) {
            folder.printRecursive(nestedIndent);
        }
    }
}