@include Test.mcfdef
@include builtin\System.mcfdef
@include builtin\Util.mcfdef
@include test\TTT.mcfdef

execUnder("test")
sysout(1111)
