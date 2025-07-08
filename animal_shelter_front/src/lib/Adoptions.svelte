<script lang="ts">
	import type {Pet} from '$lib/types';
	import LinkButton from '$lib/LinkButton.svelte';
	import Button from '$lib/Button.svelte';
	import { enhance } from '$app/forms';

	export let pet: Pet;
</script>

<li class="p-3 bg-blue-400 text-white shadow-lg">
	<ul class="justify-between flex flex-wrap">
		<li class="flex gap-5 flex-nowrap">
			<div class="min-w-45">Imię: {pet.name}</div>
			<div class="min-w-45">Gatunek: {pet.species.name}</div>
			<div class="min-w-45">Aktywność: {pet.active}</div>
			<div class="min-w-45">Przyjazność: {pet.friendly}</div>
			<div class="min-w-45">Wymagania zdrowotne: {pet.health}</div>
		</li>
		<li>
			<div class="flex gap-5 flex-nowrap">
				<LinkButton href="/adoptions/{pet.id}">Formularz</LinkButton>
			</div>
		</li>
	</ul>
</li>
