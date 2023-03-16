package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Workout type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Workouts", type = Model.Type.USER, version = 1)
@Index(name = "byUser", fields = {"userId","name"})
public final class Workout implements Model {
  public static final QueryField ID = field("Workout", "id");
  public static final QueryField NAME = field("Workout", "name");
  public static final QueryField BODY_PART = field("Workout", "bodyPart");
  public static final QueryField MUSCLE_TARGET = field("Workout", "muscleTarget");
  public static final QueryField EQUIPMENT_USED = field("Workout", "equipmentUsed");
  public static final QueryField IMAGE = field("Workout", "image");
  public static final QueryField USER = field("Workout", "userId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String", isRequired = true) String bodyPart;
  private final @ModelField(targetType="String", isRequired = true) String muscleTarget;
  private final @ModelField(targetType="String", isRequired = true) String equipmentUsed;
  private final @ModelField(targetType="String", isRequired = true) String image;
  private final @ModelField(targetType="User") @BelongsTo(targetName = "userId", targetNames = {"userId"}, type = User.class) User user;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getBodyPart() {
      return bodyPart;
  }
  
  public String getMuscleTarget() {
      return muscleTarget;
  }
  
  public String getEquipmentUsed() {
      return equipmentUsed;
  }
  
  public String getImage() {
      return image;
  }
  
  public User getUser() {
      return user;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Workout(String id, String name, String bodyPart, String muscleTarget, String equipmentUsed, String image, User user) {
    this.id = id;
    this.name = name;
    this.bodyPart = bodyPart;
    this.muscleTarget = muscleTarget;
    this.equipmentUsed = equipmentUsed;
    this.image = image;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Workout workout = (Workout) obj;
      return ObjectsCompat.equals(getId(), workout.getId()) &&
              ObjectsCompat.equals(getName(), workout.getName()) &&
              ObjectsCompat.equals(getBodyPart(), workout.getBodyPart()) &&
              ObjectsCompat.equals(getMuscleTarget(), workout.getMuscleTarget()) &&
              ObjectsCompat.equals(getEquipmentUsed(), workout.getEquipmentUsed()) &&
              ObjectsCompat.equals(getImage(), workout.getImage()) &&
              ObjectsCompat.equals(getUser(), workout.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), workout.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), workout.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getBodyPart())
      .append(getMuscleTarget())
      .append(getEquipmentUsed())
      .append(getImage())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Workout {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("bodyPart=" + String.valueOf(getBodyPart()) + ", ")
      .append("muscleTarget=" + String.valueOf(getMuscleTarget()) + ", ")
      .append("equipmentUsed=" + String.valueOf(getEquipmentUsed()) + ", ")
      .append("image=" + String.valueOf(getImage()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Workout justId(String id) {
    return new Workout(
      id,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      bodyPart,
      muscleTarget,
      equipmentUsed,
      image,
      user);
  }
  public interface NameStep {
    BodyPartStep name(String name);
  }
  

  public interface BodyPartStep {
    MuscleTargetStep bodyPart(String bodyPart);
  }
  

  public interface MuscleTargetStep {
    EquipmentUsedStep muscleTarget(String muscleTarget);
  }
  

  public interface EquipmentUsedStep {
    ImageStep equipmentUsed(String equipmentUsed);
  }
  

  public interface ImageStep {
    BuildStep image(String image);
  }
  

  public interface BuildStep {
    Workout build();
    BuildStep id(String id);
    BuildStep user(User user);
  }
  

  public static class Builder implements NameStep, BodyPartStep, MuscleTargetStep, EquipmentUsedStep, ImageStep, BuildStep {
    private String id;
    private String name;
    private String bodyPart;
    private String muscleTarget;
    private String equipmentUsed;
    private String image;
    private User user;
    @Override
     public Workout build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Workout(
          id,
          name,
          bodyPart,
          muscleTarget,
          equipmentUsed,
          image,
          user);
    }
    
    @Override
     public BodyPartStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public MuscleTargetStep bodyPart(String bodyPart) {
        Objects.requireNonNull(bodyPart);
        this.bodyPart = bodyPart;
        return this;
    }
    
    @Override
     public EquipmentUsedStep muscleTarget(String muscleTarget) {
        Objects.requireNonNull(muscleTarget);
        this.muscleTarget = muscleTarget;
        return this;
    }
    
    @Override
     public ImageStep equipmentUsed(String equipmentUsed) {
        Objects.requireNonNull(equipmentUsed);
        this.equipmentUsed = equipmentUsed;
        return this;
    }
    
    @Override
     public BuildStep image(String image) {
        Objects.requireNonNull(image);
        this.image = image;
        return this;
    }
    
    @Override
     public BuildStep user(User user) {
        this.user = user;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String bodyPart, String muscleTarget, String equipmentUsed, String image, User user) {
      super.id(id);
      super.name(name)
        .bodyPart(bodyPart)
        .muscleTarget(muscleTarget)
        .equipmentUsed(equipmentUsed)
        .image(image)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder bodyPart(String bodyPart) {
      return (CopyOfBuilder) super.bodyPart(bodyPart);
    }
    
    @Override
     public CopyOfBuilder muscleTarget(String muscleTarget) {
      return (CopyOfBuilder) super.muscleTarget(muscleTarget);
    }
    
    @Override
     public CopyOfBuilder equipmentUsed(String equipmentUsed) {
      return (CopyOfBuilder) super.equipmentUsed(equipmentUsed);
    }
    
    @Override
     public CopyOfBuilder image(String image) {
      return (CopyOfBuilder) super.image(image);
    }
    
    @Override
     public CopyOfBuilder user(User user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}
