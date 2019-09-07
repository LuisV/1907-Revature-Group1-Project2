export class Character {
  id: number;
  name: string;
  description: string;
  strength: number;
  dexterity: number;
  vitality: number;
  currentHealth: number;
  rarity: string;
  constructor( id: number,
               name: string,
               description: string,
               strength: number,
               dexterity: number,
               vitality: number,
               currentHealth: number,
               rarity: string) {
      this.id = id;
      this.name = name;
      this.strength = strength;
      this.dexterity = dexterity;
      this.description = description;
      this.currentHealth = currentHealth;
      this.rarity = rarity;
      this.vitality = 0;
    }
}
