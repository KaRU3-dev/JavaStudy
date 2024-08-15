public class CharacterModel
{
    public string? Type { get; set; }
    public string? Name { get; set; }
    public int Level { get; set; }
    public int Experience { get; set; }
    public int Health { get; set; }
    public int Mana { get; set; }
    public ArmorModel? Armor { get; set; }
    public WeaponsModel? Weapons { get; set; }
    public InventoryModel? Inventory { get; set; }
    public StatusModel? Status { get; set; }
}
