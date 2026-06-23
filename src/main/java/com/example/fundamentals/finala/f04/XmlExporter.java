package com.example.fundamentals.finala.f04;

public class XmlExporter implements Exporter {

    @Override
    public String export(String data) {
        return "<" + data + ">";
    }
}
