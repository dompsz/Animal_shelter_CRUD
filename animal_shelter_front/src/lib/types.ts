export type Pet = {
	id: number;
	name: string;
	species: Species;
	active: number;
	friendly: number;
	health: number;
}

export type Species = {
	id: number;
	name: string;
}