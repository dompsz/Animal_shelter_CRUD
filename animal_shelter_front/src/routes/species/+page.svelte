<script lang="ts">
	import Species from '$lib/Species.svelte';
	import LinkButton from '$lib/LinkButton.svelte';

	let {data} = $props();

	console.log(data);

</script>

<div class="flex justify-between my-4 items-center">
	<h2 class="text-xl font-bold">Lista Gatunków Zwierzaków</h2>
	<LinkButton href="/species/add">Dodaj</LinkButton>
</div>

<ul class="flex gap-2 flex-col">
	{#each data.species as species}
		<Species species={species}></Species>
	{/each}

</ul>