package com.example.fundamentals.finala.f04;

public class JsonExporter implements Exporter {

    @Override
    public String export(String data) {
        return "{" + data + "}";
    }
}
