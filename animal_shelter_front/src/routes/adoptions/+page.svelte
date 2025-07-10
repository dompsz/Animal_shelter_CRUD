<script lang="ts">
	import Adoptions from '$lib/Adoptions.svelte';
	import { goto } from '$app/navigation';

	let {data} = $props();

	let idealActive = $state('');
	let idealFriendly = $state('');
	let idealHealth = $state('');

	function searchMatches() {
		if (idealActive && idealFriendly && idealHealth) {
			goto(`?idealActive=${idealActive}&idealFriendly=${idealFriendly}&idealHealth=${idealHealth}`);
		}
	}

	function resetToDefault() {
		idealActive = '';
		idealFriendly = '';
		idealHealth = '';
		goto('/adoptions');
	}
</script>

<div class="flex justify-between my-4 items-center">
	<h2 class="text-xl font-bold">Lista Zwierzaków</h2>
</div>

<div class="bg-gray-100 p-4 rounded mb-4">
	<h3 class="font-bold mb-2">Znajdź idealnego zwierzaka:</h3>
	<div class="flex gap-2 items-center">
		<input
			type="number"
			bind:value={idealActive}
			placeholder="Aktywność (0-10)"
			min="0" max="10"
			class="border p-2 rounded min-w-40"
		>
		<input
			type="number"
			bind:value={idealFriendly}
			placeholder="Przyjazność (0-10)"
			min="0" max="10"
			class="border p-2 rounded min-w-40"
		>
		<input
			type="number"
			bind:value={idealHealth}
			placeholder="Zdrowie (0-10)"
			min="0" max="10"
			class="border p-2 rounded min-w-40"
		>
		<button onclick={searchMatches} class="bg-blue-500 text-white px-4 py-2 rounded">
			Znajdź
		</button>
		<button onclick={resetToDefault} class="bg-gray-500 text-white px-4 py-2 rounded">
			Reset
		</button>
	</div>
</div>

<ul class="flex gap-2 flex-col">
	{#each data.pets as pet}
		<Adoptions pet={pet}></Adoptions>
	{/each}
</ul>