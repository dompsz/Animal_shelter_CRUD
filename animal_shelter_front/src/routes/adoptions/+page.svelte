<script lang="ts">
	import Adoptions from '$lib/Adoptions.svelte';

	let {data} = $props();
</script>

<div class="flex justify-between my-4 items-center">
	<h2 class="text-xl font-bold">Lista Zwierzaków</h2>
</div>

<ul class="flex gap-2 flex-col">
	{#each data.pets as pet}
		<Adoptions pet={pet}></Adoptions>
	{/each}
</ul>