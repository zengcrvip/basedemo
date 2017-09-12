package demo.utils;

import java.util.Map;

/**
 * 按字段顺序写入
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author 15050873
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class FieldsRowWriter implements ExcelTemplate.RowWriter {
    
    private String[] fields;
    
    private int startColumn;

    public FieldsRowWriter(String[] fields, int startColumn) {
        super();
        this.fields = fields;
        this.startColumn = startColumn;
    }

    @Override
    public void write(ExcelTemplate template, int rowIndex, Map<String, ?> data) {
        for(int j = 0; j < fields.length; j++){
            template.writeCell(rowIndex, startColumn + j, data.get(fields[j]));
        }
    }

}
