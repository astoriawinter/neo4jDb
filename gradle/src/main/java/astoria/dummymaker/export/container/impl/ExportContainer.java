package astoria.dummymaker.export.container.impl;


/**
 * ExportContainer class for BasicExporter extract class method
 *
 * @see astoria.dummymaker.export.IExporter
 *
 * @author GoodforGod
 * @since 03.09.2017
 */
public class ExportContainer {

    /**
     * Export field name
     */
    private final String exportName;

    /**
     * Export field value
     */
    private final String exportValue;

    public ExportContainer(final String exportFieldName,
                           final String fieldValue) {
        this.exportName = exportFieldName;
        this.exportValue = fieldValue;
    }

    public String getExportName() {
        return exportName;
    }

    public String getExportValue() {
        return exportValue;
    }
}
