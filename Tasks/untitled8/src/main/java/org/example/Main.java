package org.example;

public class Main {
    public static void main(String[] args) {
        BlueRayDisc disc = new BlueRayDisc();

        // добавляем каталоги и файлы
        disc.addCatalog("Фильмы");
        disc.getCatalog(0).addSubCatalog("Комедии");
        disc.getCatalog(0).addSubCatalog("Драмы");
        disc.getCatalog(0).getSubCatalog(0).addFile("Крепкий орешек");
        disc.getCatalog(0).getSubCatalog(0).addFile("Маска");
        disc.getCatalog(0).getSubCatalog(1).addFile("Зеленая миля");
        disc.getCatalog(0).getSubCatalog(1).addFile("Форрест Гамп");

        disc.addCatalog("Музыка");
        disc.getCatalog(1).addFile("Queen - Bohemian Rhapsody");
        disc.getCatalog(1).addFile("Led Zeppelin - Stairway to Heaven");

        // выводим информацию о диске
        for (int i = 0; i < disc.getCatalogCount(); i++) {
            BlueRayDisc.Catalog catalog = disc.getCatalog(i);
            System.out.println("Каталог: " + catalog.name);
            for (int j = 0; j < catalog.getSubCatalogCount(); j++) {
                String subCatalog = catalog.getSubCatalog(j);
                System.out.println("\tПодкаталог: " + subCatalog);
                for (int k = 0; k < catalog.getSubCatalog(j).getFileCount(); k++) {
                    String file = catalog.getSubCatalog(j).getFile(k);
                    System.out.println("\t\tФайл: " + file);
                }
            }
            for (int j = 0; j < catalog.getFileCount(); j++) {
                String file = catalog.getFile(j);
                System.out.println("\tФайл: " + file);
            }
        }
    }
}

