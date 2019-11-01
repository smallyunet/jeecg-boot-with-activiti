# jeecg-boot-with-activiti

**描述**：基于jeecg-boot免费版，加入了对activiti的支持，使用mysql数据库（可自行更改）。目前只是一个类似脚手架的starter，并没有实现完整的页面等功能，一是开发未完成，二是jeecg-boot将此功能作为商业版出售，暂不计划完全开源。

**起因**：jeecg-boot商业版提供了对activiti的集成，实现了工作流的功能，免费版没有。

**解决的问题**：将activiti的依赖包直接引入jeecg-boot会产生依赖冲突和bean名称冲突，使用本项目可以直接进行开发，省去一些麻烦。

jeecg-boot版本： 2.1.1（发布日期：20191021）    
activiti版本：6.0.0      
mysql版本：5.X.X   

