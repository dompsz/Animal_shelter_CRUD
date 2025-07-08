<script lang="ts">
	export let href: string;
</script>

<a href={href} class="bg-white hover:bg-blue-200 text-black font-bold py-1 px-4 rounded-full">
	<slot />
</a>