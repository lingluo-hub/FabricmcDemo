# 添加物品

## 介绍
添加一个基本的物品是编写模组的第一步。你将需要创建一个 `Item` 对象，注册，并提供一个纹理。要向物品添加其他行为，你将需要一个自定义的 `Item` 类。在本教程以及以后的所有教程中，均使用 `moddemofabric` 作为命名空间。如果你有单独的模组 ID，那就直接使用它。

## 注册物品
首先，创建一个 `Item` 的实例，存储为静态常量字段。`Item` 的构造方法接受一个 `Item.Settings`（或 `FabricItemSettings`）对象，该对象用于设置物品属性，例如耐久和堆叠数量。
这里使用原版注册方式来注册，基本语法是 `Registry#register`(注册表类型, ID, 内容)，注册表类型是存储在 `Registries` 或 `Registry` 类中的静态字段，标识符用来给内容“加标签”。内容则是您添加的东西的一个实例。这可以随时调用，只要发生在初始化阶段。

```java
public class ExampleMod implements ModInitializer {
    // 新物品的实例
    public static final Item CUSTOM_ITEM = new Item(new FabricItemSettings());
 
    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"), CUSTOM_ITEM);
    }
}
```

为了简便，也可以像这样简化代码：

```java
public class ExampleMod implements ModInitializer {
 
    // an instance of our new item
    public static final Item CUSTOM_ITEM =
      Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"),
        new Item(new FabricItemSettings()));
 
    @Override
    public void onInitialize() {
    }
}
```

## 创建物品类
要为物品添加自定义行为，则需要创建一个物品类。其默认的构造方法需要一个 `Item.Settings` 对象。自定义物品类的一个实际用例是使该物品在右击时播放声音:

```java
public class CustomItem extends Item {
    public CustomItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
```

用新物品类的实例替换旧的 Item 对象:

```java
public class ExampleMod implements ModInitializer {
 
    // 新物品的实例
    public static final CustomItem CUSTOM_ITEM = new CustomItem(new FabricItemSettings());
    [...]
}
```

如果你正确执行了所有操作，则使用该物品现在应该会播放声音。

## 如果我想更改物品的堆叠大小怎么办?
使用 `FabricItemSettings` 内的 `maxCount(int size)` 来指定最大堆叠数。请注意，如果你的物品是有耐久的（及耐久归零后会被破坏），那么此物品无法设置最大堆叠数，否则游戏将抛出 `RuntimeException`。

```java
public static final CustomItem CUSTOM_ITEM = new CustomItem(new FabricItemSettings().maxCount(16));
```

## 让物品能作为燃料或者可堆肥
如果需要让物品能作为燃料在熔炉中燃烧，可以使用 `FuelRegistry`，例如：

```java
public class ExampleMod implements ModInitializer {
    [...]
 
    @Override
    public void onInitialize() {
        [...]
        FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
    }
}
```

类似地，你也可以使用 `CompostingChanceRegistry` 来让它可以在堆肥桶中堆肥。