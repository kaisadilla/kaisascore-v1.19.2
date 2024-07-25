const fs = require("fs");

let id = process.argv[2];

console.log(`Creating assets for block with id '${id}'.`);

const bsPath = `./src/main/resources/assets/kaisascore/blockstates/${id}.json`;
const blockPath = `./src/main/resources/assets/kaisascore/models/block/${id}.json`;
const itemPath = `./src/main/resources/assets/kaisascore/models/item/${id}.json`;

const bs = {
    variants: {
        "": {
            model: `kaisascore:block/${id}`
        }
    }
};

const block = {
    parent: "block/cube_all",
    textures: {
        all: `kaisascore:block/${id}`
    }
};

const item = {
    parent: `kaisascore:block/${id}`
};

fs.writeFileSync(bsPath, JSON.stringify(bs, null, 4));
fs.writeFileSync(blockPath, JSON.stringify(block, null, 4));
fs.writeFileSync(itemPath, JSON.stringify(item, null, 4));