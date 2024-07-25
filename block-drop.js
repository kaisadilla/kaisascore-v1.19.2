const fs = require("fs");

let ids = process.argv.slice(2);

for (const id of ids) {
    createFile(id);
}


function createFile (id) {
    console.log(`Creating assets for block with id '${id}'.`);

    const path = `./src/main/resources/data/kaisascore/loot_tables/blocks/${id}.json`;
    
    const data = {
        "type": "minecraft:block",
        "pools": [
            {
                "rolls": 1.0,
                "bonus_rolls": 0.0,
                "entries": [
                    {
                        "type": "minecraft:item",
                        "name": `kaisascore:${id}`
                    }
                ],
                "conditions": [
                    {
                        "condition": "minecraft:survives_explosion"
                    }
                ]
            }
        ]
    };
    
    fs.writeFileSync(path, JSON.stringify(data, null, 4));
}