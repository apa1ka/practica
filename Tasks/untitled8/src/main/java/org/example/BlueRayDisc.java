package org.example;

import java.util.ArrayList;
import java.util.List;

public class BlueRayDisc {
    private List<Catalog> catalogs = new ArrayList<>();

    // метод для добавления нового каталога
    public void addCatalog(String name) {
        Catalog catalog = new Catalog(name);
        catalogs.add(catalog);
    }

    // метод для получения количества каталогов
    public int getCatalogCount() {
        return catalogs.size();
    }

    // метод для получения каталога по индексу
    public Catalog getCatalog(int index) {
        return catalogs.get(index);
    }

    // внутренний класс Catalog
    public class Catalog {
        private String name;
        private List<String> subCatalogs = new ArrayList<>();
        private List<String> files = new ArrayList<>();

        public Catalog(String name) {
            this.name = name;
        }

        // метод для добавления подкаталога
        public void addSubCatalog(String name) {
            subCatalogs.add(name);
        }

        // метод для получения количества подкаталогов
        public int getSubCatalogCount() {
            return subCatalogs.size();
        }

        // метод для получения подкаталога по индексу
        public String getSubCatalog(int index) {
            return subCatalogs.get(index);
        }

        // метод для добавления файла
        public void addFile(String name) {
            files.add(name);
        }

        // метод для получения количества файлов
        public int getFileCount() {
            return files.size();
        }

        // метод для получения файла по индексу
        public String getFile(int index) {
            return files.get(index);
        }

        @Override
        public String toString() {
            return "Catalog{" +
                    "name='" + name + '\'' +
                    ", subCatalogs=" + subCatalogs +
                    ", files=" + files +
                    '}';
        }
    }
}

