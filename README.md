# jeecg-boot-with-activiti

jeecg-boot 版本： 2.1.1（发布日期：20191021）    
activiti 版本：6.0.0      
mysql 版本：5.x.x +
   
---

**描述**：基于jeecg-boot免费版，加入了对activiti的支持，使用mysql数据库（可自行更改）。当前项目是一个类似脚手架的starter。

**起因**：jeecg-boot商业版提供了对activiti的集成，实现了工作流的功能，免费版没有。

**解决的问题**：将activiti的依赖包直接引入jeecg-boot会产生依赖冲突和bean名称冲突，使用本项目可以直接进行开发，省去一些麻烦。

**工作流在线编辑器**：参考 [smallyunet/activiti-desginer-jquery](https://github.com/smallyunet/activiti-desginer-jquery)

**目前包含的示例**：    
- 流程模板
- 流程实例
- 任务
- 历史流程实例、任务

