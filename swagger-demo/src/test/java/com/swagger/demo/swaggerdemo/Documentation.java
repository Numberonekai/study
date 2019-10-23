//package com.swagger.demo.swaggerdemo;
//
///**
// * @auther: kai2.wang
// * @date: 2019/9/4 10:02
// * @description:
// * @version: 1.0
// */
//import io.github.robwin.markup.builder.MarkupLanguage;
//import io.github.robwin.swagger2markup.GroupBy;
//import io.github.robwin.swagger2markup.Language;
//import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
//import io.github.robwin.swagger2markup.config.Swagger2MarkupConfig;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import springfox.documentation.staticdocs.SwaggerResultHandler;
//
//import java.nio.file.Paths;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@AutoConfigureMockMvc
//@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class Documentation {
//
//    private String snippetDir = "target/generated-snippets";
//    private String outputDir = "target/asciidoc";
//    //private String indexDoc = "docs/asciidoc/index.adoc";
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @After
//    public void test() throws Exception{
//        //    输出Ascii格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://localhost:8765/v2/api-docs?group=api"))
//                .withConfig(config)
//                .build()
//                .toFolder(Paths.get("src/docs/asciidoc/generated/all"));
//    }
//
//    @Test
//    public void testApi() throws Exception{
//
//    }
//}
