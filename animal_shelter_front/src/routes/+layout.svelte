<script lang="ts">
	import '../app.css';

	let { children } = $props();
</script>

<div>
	<header class=" mb-2 bg-blue-300 font-bold text-white">
		<div class="container mx-auto px-5">
			<div class="flex items-center justify-between">
				<h1 class="py-5 text-2xl">Schronisko</h1>
				<div class="underline">
					<a href="/species">Gatunki</a>
				</div>
				<div class="underline">
					<a href="/pets">Zwierzęta</a>
				</div>
				<div class="underline">
					<a href="/adoptions">Adopcje</a>
				</div>
			</div>
		</div>
	</header>
	<div class="container mx-auto px-5">
		{@render children()}
	</div>
</div>
