--TEST--
Bug #79749 (Converting FFI instances to bool fails)
--EXTENSIONS--
ffi
--FILE--
<?php
$ffi = FFI::cdef('typedef int dummy;');
var_dump((bool) $ffi);
var_dump((bool) FFI::cdef()->type('int'));
var_dump((bool) FFI::cdef()->new('int'));
?>
--EXPECT--
bool(true)
bool(true)
bool(true)
