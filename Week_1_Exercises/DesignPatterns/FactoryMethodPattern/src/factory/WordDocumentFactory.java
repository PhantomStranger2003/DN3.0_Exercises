// factory/WordDocumentFactory.java
package factory;

import documents.Document;
import documents.WordDocument;

public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
