<script lang="ts">
	import Pet from '$lib/Pet.svelte';
	import LinkButton from '$lib/LinkButton.svelte';

	let {data} = $props();

	console.log(data);

</script>

<div class="flex justify-between my-4 items-center">
	<h2 class="text-xl font-bold">Lista Zwierzaków</h2>
	<LinkButton href="/pets/add">Dodaj</LinkButton>
</div>

<ul class="flex gap-2 flex-col">
	{#each data.pets as pet}
		<Pet pet={pet}></Pet>
	{/each}

</ul>