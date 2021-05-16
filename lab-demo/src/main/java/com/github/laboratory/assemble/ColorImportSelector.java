package com.github.laboratory.assemble;

import com.github.laboratory.assemble.color.Black;
import com.github.laboratory.assemble.color.Blue;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Description:
 * Created At 2021/5/11
 */
public class ColorImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {Blue.class.getName(), Black.class.getName()};
    }
}
