# 物品组

现在，你可以使用命令 `/give @s moddemofabric:custom_item` 来获得你的物品。要让物品更容易获得，你需要将其添加到创造模式物品栏的物品组中。你也可以添加自己的物品组。所有添加到了物品组中的物品都可以在创造模式物品栏中搜索。

## 添加物品组
首先，先决定需要将物品添加到哪个物品组。例如，添加到建筑方块物品组。原版物品组存储在 `ItemGroups` 类中。

物品可以添加到一个相对于原版物品的位置。仔细思考你的模组的用户会期望物品出现在哪里。例如，如果你添加一种新的类型的木头，那么将其添加到已有木头的后面或许是最合理的。

例如，以下这个事件监听器会将你的模组中的物品放在建筑方块物品组中的橡木门后面：

```java
ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
	content.addAfter(Items.OAK_DOOR, CUSTOM_ITEM);
});
```