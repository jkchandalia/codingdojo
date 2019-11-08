Dojo.objects.create(name="BestDojo", city="Oakland", state="CA")

Dojo.objects.create(name="KindaCoolDojo", city="Brooklyn", state="NY")

Dojo.objects.create(name="ThirdsACharm", city="Somerville", state="MA")

Dojo.objects.all().delete()

Dojo.objects.create(name="BigBrother", city="SF", state="CA")

Dojo.objects.create(name="BigApple", city="Manhattan", state="NY")

Dojo.objects.create(name="BigBean", city="Boston", state="MA")

Ninja.objects.create(dojo_id=Dojo.objects.get(id=4), first_name="HackerWoman", last_name="Extraordinaire" )
Ninja.objects.create(dojo_id=Dojo.objects.get(id=4), first_name="StandardTechBro", last_name="Ugh" )
Ninja.objects.create(dojo_id=Dojo.objects.get(id=4), first_name="AnimeQueen", last_name="Poki" )

Ninja.objects.create(dojo_id=Dojo.objects.get(id=5), first_name="Fashionista", last_name="FifthAve" )
Ninja.objects.create(dojo_id=Dojo.objects.get(id=5), first_name="StandardFinanceBro", last_name="Ugh" )
Ninja.objects.create(dojo_id=Dojo.objects.get(id=5), first_name="Artiste", last_name="Smith" )

Ninja.objects.create(dojo_id=Dojo.objects.get(id=6), first_name="NerdyGirl", last_name="FromMIT" )
Ninja.objects.create(dojo_id=Dojo.objects.get(id=6), first_name="OtherStandardFinanceBro", last_name="Ugh" )
Ninja.objects.create(dojo_id=Dojo.objects.get(id=6), first_name="NerdyBoy", last_name="FromMIT" )

Ninja.objects.filter(dojo_id=4)
Ninja.objects.filter(dojo_id=5)
Ninja.objects.filter(dojo_id=6)

Ninja.objects.all().last().dojo_id.name

Dojo.objects.create(name="SouthBayArea", city="Los Angeles", state="CA", desc="our staff comes from here?")
