package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Workout type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Workouts", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byUser", fields = {"userID","name"})
public final class Workout implements Model {
  public static final QueryField ID = field("Workout", "id");
  public static final QueryField NAME = field("Workout", "name");
  public static final QueryField USER_ID = field("Workout", "userID");
  public static final QueryField BODY_PART = field("Workout", "bodyPart");
  public static final QueryField MUSCLE_TARGET = field("Workout", "muscleTarget");
  public static final QueryField EQUIPMENT_USED = field("Workout", "equipmentUsed");
  public static final QueryField USER = field("Workout", "userId");
  public static final QueryField S3_IMAGE_KEY = field("Workout", "s3ImageKey");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="ID", isRequired = true) String userID;
  private final @ModelField(targetType="String", isRequired = true) String bodyPart;
  private final @ModelField(targetType="String", isRequired = true) String muscleTarget;
  private final @ModelField(targetType="String", isRequired = true) String equipmentUsed;
  private final @ModelField(targetType="User") @BelongsTo(targetName = "userId", targetNames = {"userId"}, type = User.class) User user;
  private final @ModelField(targetType="String") String s3ImageKey;
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
  
  public String getUserId() {
      return userID;
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
  
  public User getUser() {
      return user;
  }
  
  public String getS3ImageKey() {
      return s3ImageKey;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Workout(String id, String name, String userID, String bodyPart, String muscleTarget, String equipmentUsed, User user, String s3ImageKey) {
    this.id = id;
    this.name = name;
    this.userID = userID;
    this.bodyPart = bodyPart;
    this.muscleTarget = muscleTarget;
    this.equipmentUsed = equipmentUsed;
    this.user = user;
    this.s3ImageKey = s3ImageKey;
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
              ObjectsCompat.equals(getUserId(), workout.getUserId()) &&
              ObjectsCompat.equals(getBodyPart(), workout.getBodyPart()) &&
              ObjectsCompat.equals(getMuscleTarget(), workout.getMuscleTarget()) &&
              ObjectsCompat.equals(getEquipmentUsed(), workout.getEquipmentUsed()) &&
              ObjectsCompat.equals(getUser(), workout.getUser()) &&
              ObjectsCompat.equals(getS3ImageKey(), workout.getS3ImageKey()) &&
              ObjectsCompat.equals(getCreatedAt(), workout.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), workout.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getUserId())
      .append(getBodyPart())
      .append(getMuscleTarget())
      .append(getEquipmentUsed())
      .append(getUser())
      .append(getS3ImageKey())
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
      .append("userID=" + String.valueOf(getUserId()) + ", ")
      .append("bodyPart=" + String.valueOf(getBodyPart()) + ", ")
      .append("muscleTarget=" + String.valueOf(getMuscleTarget()) + ", ")
      .append("equipmentUsed=" + String.valueOf(getEquipmentUsed()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("s3ImageKey=" + String.valueOf(getS3ImageKey()) + ", ")
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
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      userID,
      bodyPart,
      muscleTarget,
      equipmentUsed,
      user,
      s3ImageKey);
  }
  public interface NameStep {
    UserIdStep name(String name);
  }
  

  public interface UserIdStep {
    BodyPartStep userId(String userId);
  }
  

  public interface BodyPartStep {
    MuscleTargetStep bodyPart(String bodyPart);
  }
  

  public interface MuscleTargetStep {
    EquipmentUsedStep muscleTarget(String muscleTarget);
  }
  

  public interface EquipmentUsedStep {
    BuildStep equipmentUsed(String equipmentUsed);
  }
  

  public interface BuildStep {
    Workout build();
    BuildStep id(String id);
    BuildStep user(User user);
    BuildStep s3ImageKey(String s3ImageKey);
  }
  

  public static class Builder implements NameStep, UserIdStep, BodyPartStep, MuscleTargetStep, EquipmentUsedStep, BuildStep {
    private String id;
    private String name;
    private String userID;
    private String bodyPart;
    private String muscleTarget;
    private String equipmentUsed;
    private User user;
    private String s3ImageKey;
    @Override
     public Workout build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Workout(
          id,
          name,
          userID,
          bodyPart,
          muscleTarget,
          equipmentUsed,
          user,
          s3ImageKey);
    }
    
    @Override
     public UserIdStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BodyPartStep userId(String userId) {
        Objects.requireNonNull(userId);
        this.userID = userId;
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
     public BuildStep equipmentUsed(String equipmentUsed) {
        Objects.requireNonNull(equipmentUsed);
        this.equipmentUsed = equipmentUsed;
        return this;
    }
    
    @Override
     public BuildStep user(User user) {
        this.user = user;
        return this;
    }
    
    @Override
     public BuildStep s3ImageKey(String s3ImageKey) {
        this.s3ImageKey = s3ImageKey;
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
    private CopyOfBuilder(String id, String name, String userId, String bodyPart, String muscleTarget, String equipmentUsed, User user, String s3ImageKey) {
      super.id(id);
      super.name(name)
        .userId(userId)
        .bodyPart(bodyPart)
        .muscleTarget(muscleTarget)
        .equipmentUsed(equipmentUsed)
        .user(user)
        .s3ImageKey(s3ImageKey);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder userId(String userId) {
      return (CopyOfBuilder) super.userId(userId);
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
     public CopyOfBuilder user(User user) {
      return (CopyOfBuilder) super.user(user);
    }
    
    @Override
     public CopyOfBuilder s3ImageKey(String s3ImageKey) {
      return (CopyOfBuilder) super.s3ImageKey(s3ImageKey);
    }
  }
  
}
