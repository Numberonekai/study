package com.plugs.study
/**
 * @auther: kai2.wang* @date: 2019/9/24 16:25
 * @description:
 * @version: 1.0
 */
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @auther: kai2.wang
 * @date: 2019/9/24 15:20
 * @description:
 * @version: 1.0
 */
class Demoplugs implements Plugin<Project> {
    @Override
    public void apply(Project project) {

        project.task("plugDemo"){
            println("this is my plugs")
        }
    }
}
