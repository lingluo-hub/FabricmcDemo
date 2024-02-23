# 添加基本的合成配方

阅读本教程之前，请确保添加了[物品](items.md)，我们等下会要用到。

到目前为止，我们的物品可以通过创造模式菜单或者命令获得。要让它能够在生存模式获得到，我们需要为物品添加合成配方。

在`resources/data/moddemofabric/recipes/`下创建一个名为c`ustom_item.json`的文件。这是我们制作的`custom_item`的示例配方：

```json
{
  "type": "minecraft:crafting_shaped",
  "pattern": [
    "WWW",
    "WR ",
    "WWW"
  ],
  "key": {
    "W": {
      "tag": "minecraft:logs"
    },
    "R": {
      "item": "minecraft:redstone"
    }
  },
  "result": {
    "item": "moddemofabric:custom_item",
    "count": 4
  }
}
```

配方内容解析：

- type：这是个有序合成配方。
- result：这是合成4个 tutorial:custom_item 的配方。count 字段是可选的，如果不指定 count，则默认为 1。
- pattern：代表合成配方的图案。每个字母代表一个物品。空格表示该槽位没有物品。每个字母代表的物品在 key 中定义。
- key：每个字母代表的物品。W 代表带有 minecraft:logs 标签的物品（即所有原木）。R 代表红石。关于标签的更多信息，请参考 此处。
- category：这个配方在解锁后在配方书中显示的分类。

总之，该合成配方应该是这样的：

<table>
<tr><td colspan="3"> 4 个 custom_item 的合成配方 </td></tr>
<tr><td>任何原木</td><td>任何原木</td><td>任何原木</td></tr>
<tr><td>任何原木</td><td>红石</td><td>空白</td></tr>
<tr><td>任何原木</td><td>任何原木</td><td>任何原木</td></tr>
</table>

请注意，如果你的物品是可堆叠的，那么你需要在 `result` 中指定 `count` 字段。例如，如果你的物品是堆叠的，那么你需要指定 `count` 为 9。

详细可参考：[https://fabricmc.net/wiki/zh_cn:tutorial:recipes](https://fabricmc.net/wiki/zh_cn:tutorial:recipes)