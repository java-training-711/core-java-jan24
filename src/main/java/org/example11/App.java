package org.example11;

import java.io.*;

// files
// file writer and file reader
// buffer
public class App {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.home");
        String fileName = "file1.txt";
        // new FileWriterExample(path+"/"+fileName).execute();
        // new FileReaderExample(path+"/"+fileName).execute();
        fileName = "file2.txt";
        new BufferedWriterExample(path + "/" + fileName).execute();
        new BufferedReaderExample(path + "/" + fileName).execute();

        File file = new File(path+"/"+"john.txt");
        file.createNewFile();
        System.out.println(file.exists());

        file = new File(path);
        String[] elements = file.list();
        for (String elem : elements) {
            System.out.println(elem);
        }

        File[] files = file.listFiles();
        for (File elem : files) {
            System.out.println(elem.isDirectory() + ": " + elem.getName());
        }
    }


    private static class BufferedReaderExample {
        private String resource;

        public BufferedReaderExample(String resource) {
            this.resource = resource;
        }

        public void execute() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(resource));

                while (true) {
                    int v = reader.read();
                    if (v == -1) {
                        break;
                    }
                    System.out.print((char) v);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class BufferedWriterExample {
        private String resource;

        public BufferedWriterExample(String resource) {
            this.resource = resource;
        }

        public void execute() {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(resource));
                int i = 0;
                while (i < 100) {
                    writer.write("Hello World");
                    writer.write("\n");
                    i++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (writer != null) writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static class FileReaderExample {
        private String resource;

        public FileReaderExample(String resource) {
            this.resource = resource;
        }

        public void execute() {
            FileReader reader = null;
            try {
                reader = new FileReader(resource);

                while (true) {
                    int v = reader.read();
                    if (v == -1) {
                        break;
                    }
                    System.out.print((char) v);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (reader != null) reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private static class FileWriterExample {
        private String resource;

        public FileWriterExample(String resource) {
            this.resource = resource;
        }

        public void execute() {
            FileWriter writer = null;
            try {
                writer = new FileWriter(resource);
                int i = 0;
                while (i < 100) {
                    writer.write("Hello World");
                    writer.write("\n");
                    i++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (writer != null) writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
