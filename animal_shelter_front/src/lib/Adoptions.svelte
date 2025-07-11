<script lang="ts">
	import type {Pet} from '$lib/types';
	import LinkButton from '$lib/LinkButton.svelte';
	import pies from './assets/pies.jpg';
	import kot from './assets/cat.png';
	import lion from './assets/lion.png';
	import hedgehog from './assets/hedgehog.png';

	export let gatunek: any = pies;
	export let pet: Pet;

	switch (pet.species.name) {
		case 'Pies': gatunek = pies;break;
		case 'Kot': gatunek = kot;break;
		case 'Lew': gatunek = lion;break;
		case 'Jeż': gatunek = hedgehog;break;
	}
</script>

<li class="p-3 bg-blue-400 text-white shadow-lg">
	<ul class="justify-between flex flex-wrap">
		<li>
<!--			<img class="h-25 w-25" src={"./assets/" + pet.name + ".png"} alt={pet.name} />-->
			<img class="h-25 w-25" src={gatunek} alt="zdjecie" />
		</li>
		<li class="flex gap-5 flex-nowrap">
			<div class="min-w-45">Imię: {pet.name}</div>
			<div class="min-w-35">Gatunek: {pet.species.name}</div>
			<div class="min-w-35">Aktywność: {pet.active}</div>
			<div class="min-w-35">Przyjazność: {pet.friendly}</div>
			<div class="min-w-40">Wymagania zdrowotne: {pet.health}</div>
		</li>
		<li>
			<div class="flex gap-5 flex-nowrap">
				<LinkButton href="/adoptions/{pet.id}">Formularz</LinkButton>
			</div>
		</li>
	</ul>
</li>
