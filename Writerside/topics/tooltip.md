# 添加一个物品提示

在您的[物品](items.md)类中，像这样重写 `appendTooltip`（有关如何翻译提示，请参见[lang](lang.md)）。

对于 1.19 之后的版本可以在方块类中通过重写类似方法来添加物品提示：

```java
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.moddemofabric.custom_item.tooltip"));
    }
```

详细可参考：[https://fabricmc.net/wiki/zh_cn:tutorial:tooltip](https://fabricmc.net/wiki/zh_cn:tutorial:tooltip)