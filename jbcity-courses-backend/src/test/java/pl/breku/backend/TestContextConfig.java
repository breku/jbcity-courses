package pl.breku.backend;

import org.springframework.context.annotation.ComponentScan;

/**
 * Created by breku on 25.10.17.
 */
@ComponentScan(basePackages = {
		"pl.breku.backend.course",
		"pl.breku.backend.file",
		"pl.breku.backend.config",
})
public class TestContextConfig {
}
