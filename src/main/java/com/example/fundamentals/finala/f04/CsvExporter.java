package com.example.fundamentals.finala.f04;

public class CsvExporter implements Exporter {

    @Override
    public String export(String data) {
        return "csv:" + data;
    }
}
