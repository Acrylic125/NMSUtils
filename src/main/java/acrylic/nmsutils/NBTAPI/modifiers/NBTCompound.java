package acrylic.nmsutils.NBTAPI.modifiers;

import lombok.Getter;
import net.minecraft.server.v1_8_R3.NBTBase;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagList;
import org.bukkit.Bukkit;

import java.util.Set;

@Getter
public class NBTCompound {

    private final NBTTagCompound compound;
    private final NBTCompound parent;
    private final String compoundName;

    public NBTCompound() {
        compound = new NBTTagCompound();
        this.parent = null;
        this.compoundName = null;
    }

    public NBTCompound(NBTTagCompound compound) {
        if (compound == null) compound = new NBTTagCompound();
        this.compound = compound;
        this.parent = null;
        this.compoundName = null;
    }

    protected NBTCompound(NBTTagCompound compound, String compoundName, NBTCompound parent, boolean createNew) {
        if (createNew && (compound == null || compound.isEmpty())) {
            compound = new NBTTagCompound();
            parent.set(compoundName,compound);
        }
        this.compound = compound;
        this.parent = parent;
        this.compoundName = compoundName;
    }

    public NBTCompound getCompound(String compound) {
        return new NBTCompound(this.compound.getCompound(compound), compound,this,true);
    }

    /**
     * Use this if you do not want to recreate the compound if the compound does
     * not already exist.
     */
    public NBTCompound getCompoundIfExist(String compound) {
        return new NBTCompound(this.compound.getCompound(compound), compound,this,false);
    }

    public NBTCompound buildCompound() {
        if (parent != null && compoundName != null) return parent;
        return this;
    }

    public NBTCompound removeKey(String key) {
        compound.remove(key);
        return this;
    }

    public NBTCompound set(String key, NBTCompound nbtCompound) {
        getCompound().set(key,nbtCompound.getCompound());
        return this;
    }

    public NBTCompound set(String key, byte value) {
        compound.setByte(key,value);
        return this;
    }

    public NBTCompound set(String key, short value) {
        compound.setShort(key,value);
        return this;
    }

    public NBTCompound set(String key, int value) {
        compound.setInt(key,value);
        return this;
    }

    public NBTCompound set(String key, long value) {
        compound.setLong(key,value);
        return this;
    }

    public NBTCompound set(String key, float value) {
        compound.setFloat(key,value);
        return this;
    }

    public NBTCompound set(String key, double value) {
        compound.setDouble(key,value);
        return this;
    }

    public NBTCompound set(String key, int... value) {
        compound.setIntArray(key,value);
        return this;
    }

    public NBTCompound set(String key, byte... value) {
        compound.setByteArray(key,value);
        return this;
    }

    public NBTCompound set(String key, String value) {
        compound.setString(key,value);
        return this;
    }

    public NBTCompound set(String key, NBTBase value) {
        compound.set(key, value);
        return this;
    }

    public NBTBase get(String key) {
        return compound.get(key);
    }

    public String getString(String key) {
        return compound.getString(key);
    }

    public byte getByte(String key) {
        return compound.getByte(key);
    }

    public short getShort(String key) {
        return compound.getShort(key);
    }

    public int getInt(String key) {
        return compound.getInt(key);
    }

    public long getLong(String key) {
        return compound.getLong(key);
    }

    public float getFloat(String key) {
        return compound.getFloat(key);
    }

    public double getDouble(String key) {
        return compound.getDouble(key);
    }

    public int[] getIntArray(String key) {
        return compound.getIntArray(key);
    }

    public byte[] getByteArray(String key) {
        return compound.getByteArray(key);
    }

    public NBTTagList getList(String key) {
        NBTBase list = compound.get(key);
        if (list == null) list = new NBTTagList();
        return (list instanceof NBTTagList) ? (NBTTagList) list : null;
    }

    public boolean hasKey(String key) {
        return compound.hasKey(key);
    }

    public Set<String> getKeys() {
        return compound.c();
    }

    @Override
    public String toString() {
        return "\nParent : " + parent + "\nCurrent : " + compound + "\n";
    }

}
