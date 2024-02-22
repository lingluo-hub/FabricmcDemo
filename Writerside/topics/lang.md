# 名字翻译

## 创建一个语言文件
你可以使用语言文件为游戏内的可翻译字符串提供翻译。你需要创建的文件的名称应当是语言代码，参见[Minecraft WIKI](https://zh.minecraft.wiki/w/%E8%AF%AD%E8%A8%80#%E5%8F%AF%E7%94%A8%E8%AF%AD%E8%A8%80)。
英语是 en_us，简体中文是 zh_cn，台湾繁体中文是 zh_tw，香港繁体中文是 zh_hk，文言文是 lzh。
有了语言代码后，在 `resources/assets/模组id/lang/` 的位置创建JSON文件，例如简体中文翻译的文件位置是 `resources/assets/moddemofabric/lang/zh_cn.json`。

## 添加翻译
创建语言文件后，您可以使用此基本模板添加翻译:

```json
{
  "item.tutorial.my_item": "我的物品",
  "item.tutorial.my_awesome.item": "我的物品真棒",
  [...]
}
```

详细请参考：[https://fabricmc.net/wiki/zh_cn:tutorial:lang](https://fabricmc.net/wiki/zh_cn:tutorial:lang)