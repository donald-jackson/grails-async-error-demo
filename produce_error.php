<?php

$iterations = 100;

$url = $argv[1];

$first = null;

for($i=0;$i<$iterations;$i++) {
	if(!$i) {
		$first = file_get_contents($url);
	} else {
		$current = file_get_contents($url);

		if($first != $current) {
			die("Request {$i} result is different to first request. First: {$first} - Current {$i}: {$current}\n");
		}
	}
}


echo "{$iterations} completed with no variable flipping\n";




